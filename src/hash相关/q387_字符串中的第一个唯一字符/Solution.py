class Solution:
    def firstUniqChar(self, s: str) -> int:
        if len(s)==0:
            return -1
        res = {}
        for each in s:
            if each in res:
                res[each]+=1
            else:
                res[each] = 1
        for i,each in enumerate(s):
            if res[each] ==1:
                return i
        return -1
        
