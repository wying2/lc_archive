class Solution:
    def reorganizeString(self, s: str) -> str:
        res = []
        pq = [(-count, c) for c, count in Counter(s).items()]
        heapify(pq)
        
        while pq:
            first_count, first_char = heappop(pq)
            if res and res[-1] == first_char:
                if not pq:
                    return ""
                second_count, second_char = heappop(pq)
                res.append(second_char)
                second_count += 1
                if second_count < 0:
                    heappush(pq, (second_count, second_char))
            res.append(first_char)
            first_count += 1
            if first_count < 0:
                heappush(pq, (first_count, first_char))
        return "".join(res)