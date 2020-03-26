package 动态规划.q64_最小路径和;

/**
 * 动态规划 dp(j)=grid(i,j)+min(dp(j),dp(j+1)) o(m*n)
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (j != grid[0].length - 1 && i != grid.length - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);

                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }
}
