class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        seen = set()
        while n != 1:
            n = sum(int(i) ** 2 for i in str(n))
            if n in seen:
                return False
            seen.add(n)
        return True