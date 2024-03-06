class Solution:
    def minTransfers(self, transactions: List[List[int]]) -> int:
        debts = defaultdict(int)
        for f, t, amount in transactions:
            debts[f] -= amount
            debts[t] += amount
        # print(debts)
        debts_list = [debts[id] for id in debts if debts[id]]
        # print(debts_list)
        n = len(debts_list)
        
        def backtrack(idx):
            while idx < n and debts_list[idx] == 0:
                idx += 1
            if idx == n:
                return 0 # no trasaction
            ans = sys.maxsize
            for i in range (idx+1, n):
                if debts_list[idx] * debts_list[i] < 0:
                    debts_list[i] += debts_list[idx]
                    ans = min(ans, backtrack(idx+1) +1)
                    debts_list[i] -= debts_list[idx]
            return ans
            
        return backtrack(0)