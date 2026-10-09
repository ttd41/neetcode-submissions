class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m = len(s)
        n = len(p)
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = True
        for j in range(n):
            if p[j] == '*':
                dp[0][j + 1] = dp[0][j - 1]
        for i in range(m):
            for j in range(n):
                if s[i] == p[j] or p[j] == '.':
                    dp[i + 1][j + 1] = dp[i][j]
                elif p[j] == '*':
                    if j > 0 and (s[i] == p[j - 1] or p[j - 1] == '.'):
                        dp[i + 1][j + 1] = dp[i][j + 1] or dp[i + 1][j - 1]
                    else:
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]


        return dp[m][n]

        