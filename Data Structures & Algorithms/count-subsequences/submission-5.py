class Solution:


    def numDistinct(self, s: str, t: str) -> int:
        dp = [[-1] * (len(t) + 1) for _ in range(len(s) + 1)]

        def dfs(i, j):

            if j < 0:
                return 1

            if i < 0:
                return 0

            if dp[i + 1][j + 1] != -1:
                return dp[i + 1][j + 1]
            
            base = dfs(i - 1, j)

            if s[i] == t[j]:
                base += dfs(i - 1, j - 1)

            dp[i + 1][j + 1] = base

            return dp[i + 1][j + 1]

        return dfs(len(s) - 1, len(t) - 1)
            