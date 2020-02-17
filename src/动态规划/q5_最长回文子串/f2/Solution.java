package 动态规划.q5_最长回文子串.f2;

/**
 * 动态规划 o(n^2)
 * 转移方程：字符串两边界值相等并且子字符串是回文字符串则该字符串是回文字符串
 * dp数组含义：字符串s从i到j的索引子字符串是否是回文字符串
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }

            }
        }
        return s.substring(start, start + maxLen);
    }
}
