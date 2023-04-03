package 其他.阿拉伯数字转中文;

/**
 * @author yuanguangxin
 */
public class Main {
    private static final char[] numArrays = {'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    private static final char[] units = {'十', '百', '千', '万', '亿'};
    private static final StringBuilder ans = new StringBuilder();

    private static void intToChineseNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int n = chars.length;

        // 只剩下一位时, 直接返回 numArrays 数组中对应的数字
        if (n == 1) {
            ans.append(numArrays[chars[0] - '0']);
            // 如果 num 超过 5 位, 则先判断是否上亿, 然后将 num 拆分
        } else if (n >= 5) {
            n = n >= 9 ? 9 : 5;
            int multi = (int) Math.pow(10, n - 1);
            // div 表示 num 中上亿或上万的部分数值
            int div = num / multi;
            // mod 表示剩余的部分数值
            int mod = num % multi;
            // 对前一部分数值进行转换, 然后添加单位万/亿
            intToChineseNum(div);
            ans.append(n == 5 ? units[3] : units[4]);
            String s1 = String.valueOf(div);
            String s2 = String.valueOf(mod);
            // 判断中间是否有 0
            if (s.charAt(s1.length() - 1) == '0' || s2.length() < n - 1) ans.append("零");
            // 转换剩余部分
            intToChineseNum(mod);
            // 如果 num 不超过 5 位, 处理过程与上面相似
        } else {
            int multi = (int) Math.pow(10, n - 1);
            int div = num / multi;
            int mod = num % multi;
            ans.append(numArrays[div]).append(units[n - 2]);
            if (mod != 0) {
                if (String.valueOf(mod).length() < n - 1) {
                    ans.append("零");
                }
                intToChineseNum(mod);
            }
        }
    }
}
