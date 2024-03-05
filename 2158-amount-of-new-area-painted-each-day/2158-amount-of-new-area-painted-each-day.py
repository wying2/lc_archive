from sortedcontainers import SortedList
class Solution(object):
    def amountPainted(self, paint):
        """
        :type paint: List[List[int]]
        :rtype: List[int]
        """
        
        max_pos = 0
        # construct sweep line
        record = []
        for i, [start, end] in enumerate(paint):
            record.append((start, i, 1))
            record.append((end, i, -1))
            max_pos = max(max_pos, end)
        record.sort()
        # print(record)
        ans = [0] * len(paint)
        days = SortedList()
        counter = 0
        for pos in range(max_pos+1):
            while counter < len(record) and pos == record[counter][0]:
                pos, day, typ = record[counter]
                if typ == 1:
                    days.add(day)
                else:
                    days.remove(day)
                counter += 1
                # days.sort()
                # print(days)
            if days:
                ans[days[0]] += 1
            # print(ans)
        
        return ans