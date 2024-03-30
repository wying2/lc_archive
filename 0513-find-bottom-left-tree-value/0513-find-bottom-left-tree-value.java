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
    int MaxDepth = Integer.MIN_VALUE;
    int result = 0;
    void traversal (TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > MaxDepth) {
                MaxDepth = depth;
                result = root.val;
            }
        }
        if (root.left != null) {
            // 回溯！
            depth ++;
            traversal(root.left, depth);
            depth --;
        }
        if (root.right != null) {
            // 隐藏的回溯
            traversal(root.right, depth + 1);
        }
        return;
    }
    
    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 0);
        return result;
    }
}