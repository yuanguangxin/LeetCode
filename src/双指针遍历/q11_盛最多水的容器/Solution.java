package 双指针遍历.q11_盛最多水的容器;

/**
 * 双指针遍历 o(n)
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (right > left) {
            int c = (Math.min(height[right], height[left])) * (right - left);
            if (c >= result) {
                result = c;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(a));
    }
}
