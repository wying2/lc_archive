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
    TreeNode pre;
    int min = Integer.MAX_VALUE;
    void traversal (TreeNode cur) {
        if (cur == null) return;
        traversal(cur.left);
        if (pre != null) 
            min = Math.min(Math.abs(cur.val - pre.val), min);
        pre = cur;
        traversal(cur.right);
    }
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }
}