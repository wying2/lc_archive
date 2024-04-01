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
    Set<Integer> res = new HashSet();
    int max_count = 0;
    TreeNode pre;
    int count = 0;
    void traversal (TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre == null) {
            count = 1;
        } else {
            if (pre.val == root.val) {
                count += 1;
            } else {
                count = 1;
            }
        }
        if (count > max_count) {
            max_count = count;
            res.clear();
            res.add(root.val);
        } else if (count == max_count) {
            res.add(root.val);
        }
        pre = root;
        traversal(root.right);
    }
    
    public int[] findMode(TreeNode root) {
        traversal(root);
        return res.stream().mapToInt(Number::intValue).toArray();
    }
}