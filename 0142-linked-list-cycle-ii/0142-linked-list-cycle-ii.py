# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # dummy_head = ListNode(-1, head)
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                start_over = head
                while start_over != slow:
                    start_over = start_over.next
                    slow = slow.next
                return start_over
        return None
            
# no cycle = a
# cycle = slow_seen + remain
# fast = 2x = a + 2*slow_seen + remain
# slow = x = a + slow_seen 
# fast - slow = slow_seen + remain = slow = a + slow_seen
# no cycle = remain
# slow continue
# start_over from head, when they meet it is at the entrance