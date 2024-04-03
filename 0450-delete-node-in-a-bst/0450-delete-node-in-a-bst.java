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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) root = null;
            else if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                TreeNode right_left_null = root.right;
                while (right_left_null.left != null) {
                    right_left_null = right_left_null.left;
                }
                right_left_null.left = root.left;
                root = root.right;
            }
        }
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }
}