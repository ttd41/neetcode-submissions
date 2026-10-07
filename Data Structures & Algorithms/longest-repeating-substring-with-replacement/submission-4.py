class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        maxf = 0
        fm = {}
        l = 0
        res = 0
        for r in range(0, len(s)):
            c = s[r]
            if c not in fm:
                fm[c] = 0
            fm[c] += 1
            maxf = max(maxf, fm[c])
            while (maxf + k < r - l + 1):
                fm[s[l]] -= 1
                l += 1
            res = max(r - l + 1, res)

        return res
            
        