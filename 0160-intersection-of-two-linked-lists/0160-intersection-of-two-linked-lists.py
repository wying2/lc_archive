# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = lenB = 0
        currA = headA
        currB = headB
        while currA:
            lenA += 1
            currA = currA.next
        while currB:
            lenB += 1
            currB = currB.next
        
        currA, currB = headA, headB
        
        if lenB > lenA:
            currA, currB = headB, headA
            lenA, lenB = lenB, lenA
            
        for _ in range(lenA - lenB):
            currA = currA.next
        
        while currA:
            if currA == currB:
                return currA
            else:
                currA = currA.next
                currB = currB.next
        return None