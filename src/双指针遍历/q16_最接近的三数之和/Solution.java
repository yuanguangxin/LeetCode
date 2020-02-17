package 双指针遍历.q16_最接近的三数之和;

import java.util.Arrays;

/**
 * q15类型题 数组遍历 + 双指针遍历 o(n^2)
 */

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int rs = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int c = sum - target;
                if (Math.abs(c) < Math.abs(rs - target)) {
                    rs = sum;
                }
                if (c == 0) {
                    return target;
                } else if (c > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-3, -2, -5, 3, -4};
        System.out.println(new Solution().threeSumClosest(a, -1));
    }
}
