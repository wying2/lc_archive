class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    int sum;
    void backtrack(int k, int n, int startInd) {
        if (sum > n) return;
        if (sum == n && path.size() == k) {
            res.add(new LinkedList(path));
            return;
        }
        for (int i = startInd; i <= 9; i ++) {
            path.add(i);
            sum += i;
            backtrack(k, n, i + 1);
            sum -= i;
            path.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new LinkedList();
        this.path = new LinkedList();
        this.sum = 0;
        backtrack(k, n, 1);
        return res;
    }
}