public class Solution {

    // 找到旋转数组的最小值位置
    private static int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // 最小值的位置
    }

    // 快速选择算法（类似快速排序的分区操作）
    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int pivot = partition(nums, start, end);

        if (pivot == k) {
            return nums[pivot];
        } else if (pivot > k) {
            return quickSelect(nums, start, pivot - 1, k);
        } else {
            return quickSelect(nums, pivot + 1, end, k);
        }
    }

    // 快速排序的分区操作
    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] >= pivot) { // 从大到小排序
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, end);
        return i + 1;
    }

    // 交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 主函数：在旋转数组中找到第 k 大的数字
    public static int findKthLargest(int[] nums, int k) {
        int minIndex = findMinIndex(nums); // 找到最小值的位置
        int n = nums.length;

        // 将数组分为两部分，分别查找第 k 大的数字
        if (k <= n - minIndex) {
            // 第 k 大的数字在后半部分
            return quickSelect(nums, minIndex, n - 1, k - 1);
        } else {
            // 第 k 大的数字在前半部分
            return quickSelect(nums, 0, minIndex - 1, k - (n - minIndex) - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int k = 3;

        int result = findKthLargest(nums, k);
        System.out.println("第 " + k + " 大的数字是: " + result);
    }
}