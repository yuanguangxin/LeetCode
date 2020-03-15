package 动态规划.q300_最长上升子序列;

/**
 * 动态规划 dp[i]表示以i索引下标结束的最长上升子序列 o(n*log(n))
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int rs = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] += max;
            if (dp[i] > rs) {
                rs = dp[i];
            }
        }
        return rs;
    }
}
