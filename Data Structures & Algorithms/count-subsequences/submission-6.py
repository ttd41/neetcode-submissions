class Solution:


    def numDistinct(self, s: str, t: str) -> int:
        dp = [[0] * (len(t) + 1) for _ in range(len(s) + 1)]

        for i in range(len(s)):
            dp[i][0] = 1

        for i in range(len(s)):
            for j in range(len(t)):
                dp[i + 1][j + 1] = dp[i][j + 1]
                if s[i] == t[j]:
                    dp[i + 1][j + 1] += dp[i][j]

        return dp[len(s)][len(t)]
            