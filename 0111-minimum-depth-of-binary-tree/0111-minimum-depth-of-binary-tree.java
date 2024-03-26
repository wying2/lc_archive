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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int levels = 0;
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            levels ++;
            for (int i = 0; i < size; i ++) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) return levels;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return levels;
    }
}