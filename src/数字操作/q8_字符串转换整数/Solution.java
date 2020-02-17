package 数字操作.q8_字符串转换整数;

/**
 * o(n) 重点还是判断溢出
 */
public class Solution {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }

        int rs = 0;
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (Character.isDigit(t)) {
                int temp = rs * 10 - '0' + t;
                if ((temp - t + '0') / 10 != rs || temp < 0) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                rs = temp;
            } else {
                break;
            }
        }
        return negative ? -rs : rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("2147483648"));
    }
}
