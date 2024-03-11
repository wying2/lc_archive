debug = False

class MyLinkedList(object):
    class ListNode:
        def __init__(self, val=0, next=None):
            self.val = val
            self.next = next

    def __init__(self):
        self.size = 0
        self.head = None

    # def print_list(self):
    #     curr = self.head
    #     list_arr = []
    #     while curr:
    #         list_arr.append(curr.val)
    #         curr = curr.next
    #     print(list_arr)
    
    def get(self, index):
        """
        :type index: int
        :rtype: int
        """
        # print(index, self.size)
        # print_list()
        if index < self.size:
            curr = self.head
            for i in range(index):
                curr = curr.next
            return curr.val
        if debug:
            curr = self.head
            list_arr = []
            while curr:
                list_arr.append(curr.val)
                curr = curr.next
            print(list_arr)
        return -1

    def addAtHead(self, val):
        """
        :type val: int
        :rtype: None
        """
        new_head = ListNode(val, self.head)
        self.head = new_head
        self.size += 1
        if debug:
            curr = self.head
            list_arr = []
            while curr:
                list_arr.append(curr.val)
                curr = curr.next
            print(list_arr)

    def addAtTail(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.size += 1
        if not self.head:
            self.head = ListNode(val, None)
        else:
            curr = self.head
            while curr and curr.next:
                curr = curr.next
            curr.next = ListNode(val, None)
        if debug:
            curr = self.head
            list_arr = []
            while curr:
                list_arr.append(curr.val)
                curr = curr.next
            print(list_arr)

    def addAtIndex(self, index, val):
        """
        :type index: int
        :type val: int
        :rtype: None
        """
        if index == 0:
            self.addAtHead(val)
        else:
            if index <= self.size:
                curr = self.head
                for i in range(index-1):
                    curr = curr.next
                tmp = ListNode(val, curr.next)
                curr.next = tmp
                self.size += 1
        if debug:
            curr = self.head
            list_arr = []
            while curr:
                list_arr.append(curr.val)
                curr = curr.next
            print(list_arr)

    def deleteAtIndex(self, index):
        """
        :type index: int
        :rtype: None
        """
        if index < self.size:
            if index == 0:
                self.head = self.head.next
                self.size -= 1
            else:
                curr = self.head
                for i in range(index-1):
                    curr = curr.next
                if curr.next:
                    curr.next = curr.next.next
                    self.size -= 1
        if debug:
            curr = self.head
            list_arr = []
            while curr:
                list_arr.append(curr.val)
                curr = curr.next
            print(list_arr)


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)