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
    void findPath(TreeNode root, String path, List<String> res) {
        // path = path + "->" + String.valueOf(root.val);
        if (root.left == null && root.right == null) 
            res.add(path);
        else if (root.left == null) {
            path = path + "->" + String.valueOf(root.right.val);
            findPath(root.right, path, res);
        }
        else if (root.right == null) {
            path = path + "->" + String.valueOf(root.left.val);
            findPath(root.left, path, res);
        }
        else {
            String path_l = path + "->" + String.valueOf(root.left.val);
            findPath(root.left, path_l, res);
            String path_r = path + "->" + String.valueOf(root.right.val);
            findPath(root.right, path_r, res);
        }
        return;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList();
        if (root != null) {
            String path = String.valueOf(root.val);
            findPath(root, path, res);
        }
        return res;
    }
}