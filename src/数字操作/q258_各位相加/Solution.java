package 数字操作.q258_各位相加;

/**
 * 找规律 o(1) xyz=100*x+10*y+z=99*x+9*y+x+y+z
 */
public class Solution {

    public int addDigits(int num) {
        if (num % 9 == 0 && num != 0) {
            num = 9;
        } else {
            num %= 9;
        }
        return num;
    }
}
