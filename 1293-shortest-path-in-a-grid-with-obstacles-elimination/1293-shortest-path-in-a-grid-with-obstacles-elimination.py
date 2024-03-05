class Solution(object):
    def shortestPath(self, grid, k):
        """
        :type grid: List[List[int]]
        :type k: int
        :rtype: int
        """
        rows, cols = len(grid), len(grid[0])
        target = (rows - 1, cols - 1)
        if k >= rows + cols - 2:
            return rows + cols - 2
        # row, col, remaining k
        state = (0, 0, k)
        # step, state
        queue = deque([(0, state)])
        seen = set([state])
        
        while queue:
            steps, (row, col, k) = queue.popleft()
            if (row, col) == target:
                return steps
            # try 4 directions:
            for direction in [(row-1, col), (row, col-1), (row+1, col), (row, col+1)]:
                (i, j) = direction
                # boundary check:
                if (0 <= i < rows) and (0 <= j < cols):
                    new_k = k - grid[i][j]
                    new_state = (i, j, new_k)
                    if new_k >= 0 and new_state not in seen:
                        seen.add(new_state)
                        queue.append((steps+1, new_state))
                        
        return -1