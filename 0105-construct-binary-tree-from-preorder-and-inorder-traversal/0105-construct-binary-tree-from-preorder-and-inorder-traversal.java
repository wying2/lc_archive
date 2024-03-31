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
    int[] preorder;
    int[] inorder;
    TreeNode traversal(int preorder_start, int preorder_end, int inorder_start, int inorder_end) {
        int preorder_length = preorder_end - preorder_start;
        int inorder_length = inorder_end - inorder_start;
        if (preorder_length == 0) return null;
        TreeNode root = new TreeNode(preorder[preorder_start]);
        int rootInd = -1;
        for (int i = inorder_start; i < inorder_end; i ++) {
            if (inorder[i] == preorder[preorder_start]) {
                rootInd = i;
                break;
            }
        }
        int left_inorder_start = inorder_start;
        int left_inorder_end = rootInd;
        int right_inorder_start = rootInd + 1;
        int right_inorder_end = inorder_end;
        // System.out.println("inorder start & end");
        // System.out.println("left: " + left_inorder_start + ", " + left_inorder_end);
        // System.out.println("right: " + right_inorder_start + ", " + right_inorder_end);
        
        int left_preorder_start = preorder_start + 1;
        int left_preorder_end = left_preorder_start + left_inorder_end - left_inorder_start;
        int right_preorder_start = left_preorder_end;
        int right_preorder_end = preorder_end;
        // System.out.println("preorder start & end");
        // System.out.println("left: " + left_preorder_start + ", " + left_preorder_end);
        // System.out.println("right: " + right_preorder_start + ", " + right_preorder_end);
        
        root.left = traversal(left_preorder_start, left_preorder_end, left_inorder_start, left_inorder_end);
        root.right = traversal(right_preorder_start, right_preorder_end, right_inorder_start, right_inorder_end);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return traversal(0, preorder.length, 0, inorder.length);
    }
}