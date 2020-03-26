package 栈相关.q32_最长有效括号;

import java.util.Stack;

/**
 * 利用索引栈 o(n)
 */
public class Solution {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }
}
