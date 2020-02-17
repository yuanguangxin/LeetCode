package 分治法.q33_搜索旋转排序数组;

/**
 * 循环有序数组查找 二分法o(log(n))
 */
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        //nums[mid] < nums[high]说明后半段有序
        if (nums[mid] < nums[high]) {
            //说明target在后半段
            if (nums[mid] < target && target <= nums[high]) {
                return search(nums, mid + 1, high, target);
            }
            return search(nums, low, mid - 1, target);
        } else {
            //后半段无序前半段有序，target在前半段
            if (nums[low] <= target && target < nums[mid]) {
                return search(nums, low, mid - 1, target);
            }
            return search(nums, mid + 1, high, target);
        }
    }
}