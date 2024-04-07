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
        int curr_max = -1001;
        int left = -1001;
        int right = -1001;
        if (curr.left == null && curr.right == null) {
            curr_max = curr.val;
        } else if (curr.right == null) {
            left = traversal(curr.left);
            curr_max = Math.max(left+curr.val, curr.val);
        } else if (curr.left == null) {
            right = traversal(curr.right);
            curr_max = Math.max(right+curr.val, curr.val);
        } else {
            left = traversal(curr.left);
            right = traversal(curr.right);
            curr_max = Math.max(Math.max(left+curr.val, right+curr.val), curr.val);
        }
        int[] max_candidates = new int[]{left+right+curr.val, curr_max, left, right};
        for (int i = 0; i < max_candidates.length; i ++)
            max = Math.max(max, max_candidates[i]);
        return curr_max;
    }
    public int maxPathSum(TreeNode root) {
        this.max = -1001;
        if (root == null) return 0;
        traversal(root);
        return max;
    }
}