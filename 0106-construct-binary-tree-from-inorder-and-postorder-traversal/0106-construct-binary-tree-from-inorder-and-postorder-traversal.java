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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootInd = -1;
        for (int i = 0; i < inorder.length; i ++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                rootInd = i;
                break;
            }
        }
        // System.out.println(root.val);
        // System.out.println(rootInd);
        int[] leftinorder = Arrays.copyOfRange(inorder, 0, rootInd);
        // System.out.println(Arrays.toString(leftinorder));
        int[] rightinorder = Arrays.copyOfRange(inorder, rootInd + 1, inorder.length);
        // System.out.println(Arrays.toString(rightinorder));
        int[] leftpostorder = Arrays.copyOfRange(postorder, 0, rootInd);
        int[] rightpostorder = Arrays.copyOfRange(postorder, rootInd, rootInd + rightinorder.length);
        root.left = buildTree(leftinorder, leftpostorder);
        root.right = buildTree(rightinorder, rightpostorder);
        return root;
    }
}