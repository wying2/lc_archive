class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        seen = set()
        summ = n
        
        while summ != 1:
            n = summ
            summ = 0
            while n != 0:
                digit = n % 10
                summ += digit ** 2
                n = n // 10
            if summ in seen:
                return False
            seen.add(summ)
            
        return True