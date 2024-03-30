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
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null) return findHeight(root.right) <= 1;
        else if (root.right == null) return findHeight(root.left) <= 1;
        else {
            boolean leftBalanced = isBalanced(root.left);
            boolean rightBalanced = isBalanced(root.right);
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);
            return Math.abs(leftHeight-rightHeight) <= 1 && leftBalanced && rightBalanced;
        }
    }
}