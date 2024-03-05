class Solution(object):
    def minJumps(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        # build a graph (dictionary / hashmap)
        graph = {}
        for i in range(n):
            if arr[i] in graph:
                graph[arr[i]].append(i)
            else:
                graph[arr[i]] = [i]
        
        curr = [0]
        visited = set()
        visited.add(0)
        step = 0
        
        while curr:
            nex = []
            for node in curr:
                if node == n - 1:
                    return step
                # check graph
                for child in graph.get(arr[node]):
                    if child not in visited:
                        nex.append(child)
                        visited.add(child)
                graph[arr[node]] = []
                # check front back
                for i in [node - 1, node + 1]:
                    if 0 <= i < n and i not in visited:
                        nex.append(i)
                        visited.add(i)
            step += 1
            curr = nex
        return step