class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        tmp = [0] * len(nums)
        def helper(head, tail):
            if tail <= head:
                return
            mid = head + (tail - head) // 2
            helper(head, mid)
            helper(mid + 1, tail)
            i = k = head
            j = mid + 1
            
            while i <= mid and j <= tail:
                if nums[i] < nums[j]:
                    tmp[k] = nums[i]
                    i += 1
                else:
                    tmp[k] = nums[j]
                    j += 1
                k += 1
            while i <= mid:
                tmp[k] = nums[i]
                i += 1
                k += 1
            while j <= tail:
                tmp[k] = nums[j]
                j += 1
                k += 1
            for i in range(head, tail + 1):
                nums[i] = tmp[i]
        helper(0, len(nums)-1)
        return nums
                    
            
        
        
#         self.mergeSort(nums)
#         return nums
#     def mergeSort(self, nums): 
#         if len(nums) > 1: 
#             mid = len(nums)//2
#             L = nums[:mid] 
#             R = nums[mid:] 

#             self.mergeSort(L)
#             self.mergeSort(R)

#             i = j = k = 0

#             while i < len(L) and j < len(R): 
#                 if L[i] < R[j]: 
#                     nums[k] = L[i] 
#                     i+=1
#                 else: 
#                     nums[k] = R[j] 
#                     j+=1
#                 k+=1
 
#             while i < len(L): 
#                 nums[k] = L[i] 
#                 i+=1
#                 k+=1

#             while j < len(R): 
#                 nums[k] = R[j] 
#                 j+=1
#                 k+=1