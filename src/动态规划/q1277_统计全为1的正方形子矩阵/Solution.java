package 动态规划.q1277_统计全为1的正方形子矩阵;

/**
 * 动态规划 dp[i][j]表示 matrix[i][j] 这个点可以往左上构造的最大正方形的边长 o(n^2)
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int rs = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    rs += dp[i][j];
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        new Solution().countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}});
    }
}
