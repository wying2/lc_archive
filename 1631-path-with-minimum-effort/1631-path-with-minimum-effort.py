class UnionFind:
    def __init__ (self, n:int):
        self.father = [i for i in range(n)]
    
    def find (self, u):
        if u != self.father[u]:
            self.father[u] = self.find(self.father[u])
        return self.father[u]
    
    def isSame(self, u, v):
        u = self.find(u)
        v = self.find(v)
        return u == v
    
    def join(self, u, v):
        u = self.find(u)
        v = self.find(v)
        if (u == v):
            return
        self.father[v] = u
        

class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        edges = []
        for i in range(m):
            for j in range(n):
                ind = i * n + j
                if i > 0:
                    edges.append((ind - n, ind, abs(heights[i][j] - heights[i-1][j])))
                if j > 0:
                    edges.append((ind - 1, ind, abs(heights[i][j] - heights[i][j-1])))
        edges.sort(key=lambda e : e[2])
        ans = 0
        uf = UnionFind(m * n)
        for x, y, v in edges:
            uf.join(x, y)
            if uf.isSame(0, m * n - 1):
                ans = v
                break
        return ans