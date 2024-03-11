# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    
    def simulation(self, head):
        if not head:
            return None
        dummy_head = ListNode(-1, head)
        pre = dummy_head
        left = head
        right = head.next
        while left and right:
            pre.next = right
            left.next = right.next
            right.next = left
            pre = left
            left = pre.next
            if left:
                right = left.next
        
        return dummy_head.next
    
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.simulation(head)
        
            