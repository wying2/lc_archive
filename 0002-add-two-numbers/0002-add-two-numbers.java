/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        int carrier = 0;
        while (l1 != null || l2 != null || carrier != 0) {
            int v1 = l1 == null? 0 : l1.val;
            int v2 = l2 == null? 0 : l2.val;
            int sum = v1 + v2 + carrier;
            curr.next = new ListNode(sum % 10);
            carrier = sum / 10;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}