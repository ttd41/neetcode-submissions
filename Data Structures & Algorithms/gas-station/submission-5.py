class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1
        start_gas = 0
        left = 0
        total = 0
        res = 0
        for i, c in enumerate(cost):
            left += gas[i] - c
            if left < 0:
                res = i + 1
                left = 0

        return res
            
