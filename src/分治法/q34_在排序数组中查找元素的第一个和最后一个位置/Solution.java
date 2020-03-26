package 分治法.q34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * 二分法 o(log(n))
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int midIndex = find(0, nums.length - 1, nums, target);
        int[] rs = new int[2];
        rs[0] = midIndex;
        rs[1] = midIndex;
        if (midIndex == -1) {
            return rs;
        }
        while (nums[rs[0]] == target && rs[0] > 0) {
            int temp = find(0, rs[0] - 1, nums, target);
            if (temp == -1) {
                break;
            } else {
                rs[0] = temp;
            }
        }

        while (nums[rs[1]] == target && rs[1] < nums.length - 1) {
            int temp = find(rs[1] + 1, nums.length - 1, nums, target);
            if (temp == -1) {
                break;
            } else {
                rs[1] = temp;
            }
        }
        return rs;
    }

    public int find(int beginIndex, int endIndex, int[] nums, int target) {
        if (beginIndex == endIndex) {
            if (nums[beginIndex] == target) {
                return beginIndex;
            } else {
                return -1;
            }
        }
        int mid = (endIndex - beginIndex) / 2 + beginIndex;
        if (nums[mid] > target) {
            return find(beginIndex, mid, nums, target);
        } else if (nums[mid] < target) {
            return find(mid + 1, endIndex, nums, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        new Solution().searchRange(new int[]{2, 2}, 2);
    }
}
