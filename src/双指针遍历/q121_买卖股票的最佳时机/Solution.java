package 双指针遍历.q121_买卖股票的最佳时机;

/**
 * 维护一个最低股价变量，同时维护当前收益o(n)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int money = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > money) {
                money = prices[i] - min;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(a));
    }
}
