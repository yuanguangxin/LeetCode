package 动态规划.q62_不同路径;

/**
 * 动态规划 dp[i][j]是到达i, j的最多路径 dp[i][j] = dp[i-1][j] + dp[i][j-1] o(m*n)
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
