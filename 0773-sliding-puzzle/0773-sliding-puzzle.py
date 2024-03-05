class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        moves = {0: [1, 3], 1: [0, 2, 4], 2: [1, 5], 3: [0, 4], 4: [1, 3, 5], 5: [2, 4]}
        queue = []
        visit = set()
        currs = ''.join(str(d) for row in board for d in row )
        currp = currs.index("0")
        step = 0
        queue.append((currs, currp))
        visit.add(currs)
        
        while queue:
            nex = []
            for s, p in queue:
                if s == "123450":
                    return step
                for i in moves[p]:
                    new_arr = [d for d in s]
                    new_arr[i], new_arr[p] = s[p], s[i]
                    new_s = ''.join(new_arr)
                    if new_s not in visit:
                        visit.add(new_s)
                        nex.append((new_s, i))
            step = step + 1
            queue = nex
        
        return -1