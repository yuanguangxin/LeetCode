package 数字操作.q172_阶乘后的零.f2;

/**
 * 基于方法一，寻找5出现的规律o(log(n))
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
