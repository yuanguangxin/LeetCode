package 数组操作.q581_最短无序连续子数组;

import java.util.Arrays;

/**
 * 利用排序 o(n*log(n))
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] cloneNums = nums.clone();
        Arrays.sort(nums);

        int begin = Integer.MAX_VALUE;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != cloneNums[i]) {
                begin = Math.min(begin, i);
                end = Math.max(end, i);
            }
        }
        return Math.max(end - begin + 1, 0);
    }

    public static void main(String[] args) {
        new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}
