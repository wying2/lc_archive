class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        loop = n // 2
        mid = n // 2
        count = 1
        start_x, start_y = 0, 0
        ans = [[0] * n for _ in range(n)]
        for level in range(1, loop + 1):
            i, j = start_x, start_y
            
            # 0,0 -> 0,3
            for i in range(start_x, n - level):
                ans[start_y][i] = count
                count += 1
            # print(ans)
            start_x = i + 1
            # print(start_x, start_y)
            # 0,4 -> 3,4
            for j in range(start_y, n - level):
                ans[j][start_x] = count
                count += 1
            # print(ans)
            start_y = j + 1
            # 4,4 -> 4,1
            for i in range(start_x, level - 1, -1):
                ans[start_y][i] = count
                count += 1
            start_x = i - 1
            # 4,0 -> 1,0
            for j in range(start_y, level - 1, -1):
                ans[j][start_x] = count
                count += 1
            start_y = j
            start_x += 1
        # print(ans)
        if n % 2 == 1:
            ans[mid][mid] = count
        return ans