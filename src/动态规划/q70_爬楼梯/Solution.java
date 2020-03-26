package 动态规划.q70_爬楼梯;

/**
 * 动态规划 dp[i]表示到达第i阶的方法总数dp[i]=dp[i−1]+dp[i−2] o(n)
 */
public class Solution {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
