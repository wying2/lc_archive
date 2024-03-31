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
    
    int[] inorder;
    int[] postorder;
    TreeNode traversal (int inorder_start, int inorder_end, int postorder_start, int postorder_end) {
        int postorder_length = postorder_end - postorder_start;
        int inorder_length = inorder_end - inorder_start;
        if (postorder_length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder_end - 1]);
        int rootInd = -1;
        for (int i = inorder_start; i < inorder_end; i ++) {
            if (inorder[i] == postorder[postorder_end - 1]) {
                rootInd = i;
                break;
            }
        }
        // System.out.println(root.val);
        // System.out.println(rootInd);
        
        int left_inorder_start = inorder_start;
        int left_inorder_end = rootInd;
        
        // System.out.println("left_inorder_start: " + left_inorder_start + " left_inorder_end: " + left_inorder_end);
        
        int right_inorder_start = rootInd + 1;
        int right_inorder_end = inorder_end;
        // System.out.println("right_inorder_start: " + right_inorder_start + " right_inorder_end: " + right_inorder_end);
        
        int left_postorder_start = postorder_start;
        int left_postorder_end = postorder_start + left_inorder_end - left_inorder_start;
        // System.out.println("left_postorder_start: " + left_postorder_start + " left_postorder_end: " + left_postorder_end);
        
        int right_postorder_start = postorder_start + rootInd - inorder_start;
        int right_postorder_end = postorder_end - 1;
        // System.out.println("right_postorder_start: " + right_postorder_start + " right_postorder_end: " + right_postorder_end);
        
        
        root.left = traversal(left_inorder_start, left_inorder_end, left_postorder_start, left_postorder_end);
        root.right = traversal(right_inorder_start, right_inorder_end, right_postorder_start, right_postorder_end);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return traversal(0, inorder.length, 0, postorder.length);
    }
}