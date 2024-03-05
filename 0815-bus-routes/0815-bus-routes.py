class Solution(object):
    def numBusesToDestination(self, routes, source, target):
        """
        :type routes: List[List[int]]
        :type source: int
        :type target: int
        :rtype: int
        """
        if source == target:
            return 0
        route_num = len(routes)
        # build graph
        graph = {}
        for r in range(route_num):
            for stop in routes[r]:
                if stop in graph:
                    graph[stop].append(r)
                else:
                    graph[stop] = [r]
        # build queue and visited, put all route # with source
        queue = []
        visited = set()
        for r in graph.get(source, []):
            queue.append(r)
            visited.add(r)
        busCount = 1
        while queue:
            nex = []
            for r in queue:
                for stop in routes[r]:
                    if stop == target:
                        return busCount
                    for convert in graph[stop]:
                        if convert not in visited:
                            nex.append(convert)
                            visited.add(convert)
                    graph[stop] = []
            busCount += 1
            queue = nex
        return -1
            
            