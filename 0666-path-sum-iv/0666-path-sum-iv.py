class Solution:
    def pathSum(self, nums: List[int]) -> int:
        dic = defaultdict(int)
        for n in nums:
            layer = n // 100
            pos = n // 10 - layer * 10
            val = n % 10
            dic[layer, pos] = dic[layer-1, (pos+1)//2] + val
        res = 0
        print(dic)
        for layer, pos in dic.keys():
            if (layer+1, pos*2) not in dic.keys() and (layer+1, pos*2-1) not in dic.keys():
                res += dic[layer, pos]
        return res