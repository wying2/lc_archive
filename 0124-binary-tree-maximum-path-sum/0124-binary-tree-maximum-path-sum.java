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
    int max;
    int traversal(TreeNode curr) {
        if (curr == null) return 0;
        int left = Math.max(traversal(curr.left), 0);
        int right = Math.max(traversal(curr.right), 0);
        int curr_max = Math.max(left, right) + curr.val;
        max = Math.max(left + right + curr.val, max);
        return curr_max;
    }
    public int maxPathSum(TreeNode root) {
        this.max = -1001;
        traversal(root);
        return max;
    }
}