class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = []
        dicts = {}
        if len(nums)<=1:
            return res
        for i,each in enumerate(nums):
            if (target-each) in dicts:
                res.append(i)
                res.append(dicts[target-each])
                return res
            else:
                dicts[each] = i
        return res
