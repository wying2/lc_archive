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
    boolean result = false;
    void traversal (TreeNode root, int sum, int targetSum) {
        if (root == null) return;
        sum += root.val;
        // if (sum > targetSum) return;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) result = true;
            return;
        }
        if (root.left != null) traversal(root.left, sum, targetSum);
        if (root.right != null) traversal(root.right, sum, targetSum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // if (root != null)
        traversal(root, 0, targetSum);
        return result;
    }
}