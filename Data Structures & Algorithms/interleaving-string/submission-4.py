class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False
        
        len1 = len(s1)
        len2 = len(s2)

        dp = [[False] * (len2 + 1) for _ in range(len1 + 1)]
        dp[0][0] = True

        for i in range(0, len(s1) + 1):
            for j in range(0, len(s2) + 1):
                if i > 0 and s3[i + j - 1] == s1[i - 1]:
                    dp[i][j] |= dp[i - 1][j]
                if j > 0 and s3[i + j - 1] == s2[j - 1]:
                    dp[i][j] |= dp[i][j - 1]
        

        return dp[len1][len2]

