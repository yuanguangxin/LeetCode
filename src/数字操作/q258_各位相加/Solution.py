class Solution:
    def addAll(self,num:int) ->int:
        res = 0
        while num>0:
            res+=num%10
            num = num//10
            print(num)
        print(res)
        return res
    def addDigits(self, num: int) -> int:
        if num//10==0:
            return num
        res = self.addAll(num)
        print(res)
        while res//10!=0:
            res = self.addAll(res)
        return res
