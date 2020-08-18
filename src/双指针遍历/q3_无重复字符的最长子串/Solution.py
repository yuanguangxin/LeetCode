class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)<=1:
            return len(s)
        res = []
        i = 0
        j = 0
        ans = 1
        n = len(s)
        while i<n and j<n:
            if s[j] not in res:
                res.append(s[j])
                j+=1
                ans = max(ans,j-i)
            else:
                res.remove(s[i])
                i+=1
        return ans

