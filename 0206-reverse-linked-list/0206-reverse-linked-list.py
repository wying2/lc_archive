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
            
    def recursive(self, head):
        def helper(pre, cur):
            if not cur:
                return pre
            nex = cur.next
            cur.next = pre
            return helper(cur, nex)
        return helper(None, head)
    
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # return self.twoPointers(head)
        return self.recursive(head)