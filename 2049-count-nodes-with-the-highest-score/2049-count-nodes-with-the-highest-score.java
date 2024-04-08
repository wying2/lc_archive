class Solution {
    private int count;
    private long max;
    private int n;
    private List<Integer>[] tree;
    
    // returning the size
    private int dfs(int i) {
        long score = 1;
        int size = 1;
        for (int num: tree[i]) {
            int t = dfs(num);
            score *= t;
            size += t;
        }
        if (i != 0)
            score *= (n - size);
        if (score == max)
            count ++;
        else if (score > max) {
            max = score;
            count = 1;
        }
        return size;
    }
    
    public int countHighestScoreNodes(int[] parents) {
        this.n = parents.length;
        // build tree w parents 
        this.tree = new List[n];
        for (int i = 0; i < n; i ++) {
            tree[i] = new ArrayList();
        }
        
        for (int i = 0; i < n; i ++) {
            if (parents[i] != -1) {
                tree[parents[i]].add(i);
            }
        }
        
        // dfs on tree
        dfs(0);
        return count;
    }
}

// if root (no parent): left.sz * right.sz ()
// if leaf: sz of tree - 1
// if not root or leaf: left.sz * right.sz * (tree.sz - this.sz)

// 0, len(parents) arraylist<list> ind = parent list storing children
// dfs: summing for the parent