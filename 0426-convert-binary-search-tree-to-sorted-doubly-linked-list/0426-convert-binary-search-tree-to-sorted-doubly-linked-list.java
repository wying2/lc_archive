/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node pre;
    Node head;
    void traversal (Node curr) {
        if (curr == null) return;
        traversal(curr.left);
        if (pre == null) head = curr;
        if (pre != null) {
            pre.right = curr;
            curr.left = pre;
        }
        pre = curr;
        traversal(curr.right);
    }
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        traversal(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
}