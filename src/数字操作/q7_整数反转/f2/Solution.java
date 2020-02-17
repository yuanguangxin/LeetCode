package 数字操作.q7_整数反转.f2;

/**
 * 求余（判断是否溢出有多种方式） o(log(n))
 */
public class Solution {
    public int reverse(int x) {
        int rs = 0;
        while (true) {
            int y = x % 10;
            x = x / 10;
            if (rs * 10 / 10 != rs) {
                return 0;
            }
            rs = rs * 10 + y;
            if (x == 0) {
                break;
            }
        }
        return rs;
    }
}
