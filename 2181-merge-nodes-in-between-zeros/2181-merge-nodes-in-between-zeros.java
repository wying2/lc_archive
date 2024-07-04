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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        int sum = 0;
        ListNode returnDummy = new ListNode(0, null);
        ListNode returnCurr = returnDummy;
        while (curr != null) {
            if (curr.val == 0 && sum != 0) {
                ListNode tmp = new ListNode(sum);
                returnCurr.next = tmp;
                returnCurr = returnCurr.next;
                sum = 0;
            } else {
                sum += curr.val;
            }
            curr = curr.next;
        }
        return returnDummy.next;
    }
}