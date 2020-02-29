package 堆相关.q215_数组中的第K个最大元素;

import java.util.PriorityQueue;

/**
 * 利用大根堆实现 o(n*log(k))
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
}
