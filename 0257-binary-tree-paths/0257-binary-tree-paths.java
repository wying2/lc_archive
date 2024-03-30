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
    void findPath(TreeNode root, ArrayList<Integer> path, List<String> res) {
        // path = path + "->" + String.valueOf(root.val);
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i ++) {
                sb.append(String.valueOf(path.get(i))).append("->");
            }
            sb.append(String.valueOf(path.get(path.size()-1)));
            res.add(sb.toString());
        }
        if (root.left != null) {
            findPath(root.left, path, res);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            findPath(root.right, path, res);
            path.remove(path.size()-1);
        }
        return;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList();
        if (root != null) {
            ArrayList<Integer> path = new ArrayList();
            findPath(root, path, res);
        }
        return res;
    }
}