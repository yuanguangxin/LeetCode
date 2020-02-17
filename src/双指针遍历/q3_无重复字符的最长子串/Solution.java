package 双指针遍历.q3_无重复字符的最长子串;

import java.util.HashMap;

/**
 * Hash+双指针滑动窗口 o(n)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                left = index + 1;
            }
            if (right - left + 1 > len) {
                len = right - left + 1;
            }
            right++;
        }
        return len;
    }
}
