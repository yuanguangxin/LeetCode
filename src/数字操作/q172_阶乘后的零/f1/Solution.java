package 数字操作.q172_阶乘后的零.f1;

/**
 * 找因子直接遍历（o(n)超时）
 */
public class Solution {
    public int trailingZeroes(int num) {
        int rs = 0;
        for (int i = 1; i <= num; i++) {
            int j = i;
            while (j % 5 == 0) {
                rs++;
                j /= 5;
            }
        }
        return rs;
    }
}
