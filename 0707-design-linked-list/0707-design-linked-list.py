class MyLinkedList(object):
    class ListNode:
        def __init__(self, val=0, next=None):
            self.val = val
            self.next = next
            

    def __init__(self):
        self.dummy_head = ListNode()
        self.size = 0
        

    def get(self, index):
        """
        :type index: int
        :rtype: int
        """
        if index < 0 or index >= self.size:
            return -1
        curr = self.dummy_head.next
        
        for _ in range(index):
            curr = curr.next
        
        return curr.val

    def addAtHead(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.dummy_head.next = ListNode(val, self.dummy_head.next)
        self.size += 1
        

    def addAtTail(self, val):
        """
        :type val: int
        :rtype: None
        """
        curr = self.dummy_head
        while curr.next:
            curr = curr.next
        curr.next = ListNode(val, None)
        self.size += 1
        

    def addAtIndex(self, index, val):
        """
        :type index: int
        :type val: int
        :rtype: None
        """
        if index < 0 or index > self.size:
            return
        curr = self.dummy_head
        for _ in range(index):
            curr = curr.next
        curr.next = ListNode(val, curr.next)
        self.size += 1
        

    def deleteAtIndex(self, index):
        """
        :type index: int
        :rtype: None
        """
        if index < 0 or index >= self.size:
            return
        curr = self.dummy_head
        for _ in range(index):
            curr = curr.next
        curr.next = curr.next.next
        self.size -= 1


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)