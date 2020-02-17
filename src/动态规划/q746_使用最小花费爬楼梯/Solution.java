package 动态规划.q746_使用最小花费爬楼梯;

/**
 * 动态规划 o(n) f[i] = cost[i] + min(f[i+1], f[i+2])
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 2, 1};
        System.out.println(new Solution().minCostClimbingStairs(a));
    }
}
