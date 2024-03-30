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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftCount = 0, rightCount = 0;
        while (left != null) {
            left = left.left;
            leftCount += 1;
        }
        while (right != null) {
            right = right.right;
            rightCount += 1;
        }
        if (leftCount == rightCount) 
            return (2 << leftCount) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}