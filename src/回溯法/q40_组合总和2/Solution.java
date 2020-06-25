package 回溯法.q40_组合总和2;

import java.util.*;

/**
 * 回溯法 O(n*log(n))
 */
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, new LinkedList<>(), res);
        return res;
    }

    public void helper(int[] candidates, int target, int start, LinkedList<Integer> stack, List<List<Integer>> res) {
        if (start > candidates.length) {
            return;
        }
        if (target == 0 && !stack.isEmpty()) {
            List<Integer> item = new ArrayList<>(stack);
            res.add(item);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < candidates.length; ++i) {
            if (!set.contains(candidates[i]) && target >= candidates[i]) {
                stack.push(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, stack, res);
                stack.pop();
                set.add(candidates[i]);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
