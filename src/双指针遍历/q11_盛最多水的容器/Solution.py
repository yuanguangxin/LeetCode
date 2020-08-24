class Solution:
    def maxArea(self, height: List[int]) -> int:
        if len(height)<2:
            return 0
        begin = 0
        end = len(height)-1
        maxValue = 0
        while begin<=end:
            maxValue = max((end-begin)*min(height[begin],height[end]),maxValue)
            print(maxValue)
            if height[begin]<height[end]:
                begin+=1
            else:
                end-=1
        return maxValue
