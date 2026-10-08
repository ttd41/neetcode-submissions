class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start_gas = 0
        left = 0
        total = 0
        res = 0
        for i, c in enumerate(cost):
            left += gas[i] - c
            total += gas[i] - c
            if left < 0:
                res = i + 1
                left = 0

        return -1 if total < 0 else res
            
