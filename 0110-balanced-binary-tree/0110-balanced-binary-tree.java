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
    int findHeight (TreeNode root) {
        if (root == null) return 0;
        int leftHeight = findHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = findHeight(root.right);
        if (rightHeight == -1) return -1;
        int res = Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
        return res;
    }
    
    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }
}