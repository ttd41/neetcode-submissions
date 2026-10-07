class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        real = 0
        expected = 0
        for i, n in enumerate(nums):
            real ^= n
            expected ^= i
        expected ^= len(nums)
        return expected ^ real
