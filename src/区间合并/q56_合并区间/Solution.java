package 区间合并.q56_合并区间;


import java.util.*;

/**
 * 先根据start进行排序之后merge o(n*log(n))
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int[] currInterval = intervals[0];
        List<int[]> resArr = new ArrayList<>();
        resArr.add(currInterval);

        for(int[] interval: intervals){
            int currEnd = currInterval[1];

            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if(currEnd >= nextBegin){
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else{
                currInterval = interval;
                resArr.add(currInterval);
            }
        }

        return resArr.toArray(new int[resArr.size()][]);
    }
}
