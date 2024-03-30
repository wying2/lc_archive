/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int targetSum;
    List<List<Integer>> paths = new LinkedList();
    void traversal (TreeNode root, List<Integer> path, int sum) {
        if (root == null) return;
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                ArrayList<Integer> path_copy = new ArrayList();
                for (Integer i : path)
                    path_copy.add(i);
                paths.add(path_copy);
            }
            return;
        }
        if (root.left != null) {
            traversal(root.left, path, sum);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, path, sum);
            path.remove(path.size() - 1);
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        traversal(root, new ArrayList<Integer>(), 0);
        return paths;
    }
}