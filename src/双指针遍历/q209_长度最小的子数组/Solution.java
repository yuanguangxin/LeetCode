package 双指针遍历.q209_长度最小的子数组;

/**
 * 两个指针滑动窗口o(n)
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        int k = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            if (k == nums.length && i == nums.length) {
                break;
            }
            if (sum < s) {
                if (k == nums.length) {
                    break;
                }
                sum += nums[k];
                k++;
            } else {
                min = Math.min(k - i, min);
                sum -= nums[i];
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
