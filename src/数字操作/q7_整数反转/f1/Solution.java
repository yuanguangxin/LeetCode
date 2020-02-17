package 数字操作.q7_整数反转.f1;

/**
 * 转成String o(n) 捕获异常判断是否溢出
 */
public class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        String rs = "";
        boolean f = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                f = true;
            } else {
                rs += s.charAt(i);
            }
        }
        try {
            return f ? Integer.parseInt(rs) * (-1) : Integer.parseInt(rs);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1234));
    }
}
