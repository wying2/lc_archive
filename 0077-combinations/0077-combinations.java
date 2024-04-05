class Solution {
    LinkedList<Integer> path;
    List<List<Integer>> res;
    
    void backtrack(int n, int k, int startInd) {
        if (path.size() == k) {
            res.add(new LinkedList(path));
            return;
        }
        for (int i = startInd; i <= n - (k - path.size()) + 1; i ++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.removeLast();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        this.path = new LinkedList();
        this.res = new LinkedList();
        backtrack(n, k, 1);
        return res;
    }
}