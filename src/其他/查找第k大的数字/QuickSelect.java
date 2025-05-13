package 其他.查找第k大的数字;

public class QuickSelect {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) { // 如果只剩一个元素，那么它就是第k小的
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];  // 选择最右边的元素作为pivot
        int i = left; // i是小于pivot的元素的最后一个位置
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right); // 把pivot放到中间位置
        return i; // 返回pivot的正确位置
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2; // 找第2大的数字（即第k大的数字）
        System.out.println("第 " + k + " 大的数字是: " + findKthLargest(nums, k)); // 输出应该是5
    }
}
