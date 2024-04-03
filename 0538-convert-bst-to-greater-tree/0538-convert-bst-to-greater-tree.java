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
    int post = 0;
    void traversal(TreeNode curr) {
        if (curr == null) return;
        traversal(curr.right);
        curr.val += post;
        post = curr.val;
        traversal(curr.left);
    }
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

}