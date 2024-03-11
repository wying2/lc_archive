# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    
    def twoPointers(self, head):
        if not head:
            return None
        pre = None
        cur = head
        
        while cur:
            nex = cur.next
            cur.next = pre
            pre = cur
            cur = nex
        return pre
            
    
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.twoPointers(head)