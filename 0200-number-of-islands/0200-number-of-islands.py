class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        m = len(grid[0])
        n = len(grid)
        visited = [[False] * m for _ in range(n)]
        # print(grid)
        count = 0
        for i in range(n):
            for j in range(m):
                # print(grid[i][j])
                # print(visited[i][j])
                if not visited[i][j] and grid[i][j] == "1":
                    queue = []
                    queue.append((i,j))
                    # print(queue)
                    visited[i][j] = True
                    while queue:
                        # print(queue)
                        x, y = queue.pop()
                        # print(x, y)
                        for dx, dy in dirs:
                            curr_x = x + dx
                            curr_y = y + dy
                            # print(curr_x, curr_y)
                            if curr_x < 0 or curr_x >= n or curr_y < 0 or curr_y >= m:
                                continue
                            if visited[curr_x][curr_y] or grid[curr_x][curr_y] == "0":
                                continue
                            queue.append((curr_x, curr_y))
                            visited[curr_x][curr_y] = True
                    count += 1
        return count;