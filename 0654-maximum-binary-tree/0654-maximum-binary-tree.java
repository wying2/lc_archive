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
    TreeNode traversal (int[] nums, int start, int end) {
        if (end - start == 0) return null;
        int max = -1;
        int max_ind = -1;
        for (int i = start; i < end; i ++) {
            if (nums[i] > max) {
                max = nums[i];
                max_ind = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = traversal(nums, start, max_ind);
        root.right = traversal(nums, max_ind + 1, end);
        return root;
    }
        
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return traversal(nums, 0, nums.length);
    }
}