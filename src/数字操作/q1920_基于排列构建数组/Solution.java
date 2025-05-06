package 数字操作.q1920_基于排列构建数组;

/**
 * 注意观察题目，数组中数字为[0,999]闭区间
 */
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
            System.out.println(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 0, 1, 4};
        new Solution().buildArray(nums);
    }
}
