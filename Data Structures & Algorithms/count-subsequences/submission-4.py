class Solution:


    def numDistinct(self, s: str, t: str) -> int:
        self._s = s
        self._t = t
        self.dp = [[-1] * (len(t) + 1) for _ in range(len(s) + 1)]

        return self.dfs(len(s) - 1, len(t) - 1)

    def dfs(self, i, j):

        if j < 0:
            return 1

        if i < 0:
            return 0

        if self.dp[i + 1][j + 1] != -1:
            return self.dp[i + 1][j + 1]
        
        base = self.dfs(i - 1, j)

        if self._s[i] == self._t[j]:
            base += self.dfs(i - 1, j - 1)

        self.dp[i + 1][j + 1] = base

        return self.dp[i + 1][j + 1]
            