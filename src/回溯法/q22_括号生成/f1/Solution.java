package 回溯法.q22_括号生成.f1;

import java.util.*;

/**
 * 暴力法 o(2^2n*n)
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(') {
                stack.push(t);
            } else {
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public List<String> generateParenthesis(int n) {
        List<String> rs = new ArrayList<>();

        if (n < 1) {
            return rs;
        }
        String root = "(";
        rs.add(root);
        for (int k = 0; k < 2 * n - 1; k++) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < rs.size(); i++) {
                String temp = rs.get(i);
                tempList.add(temp + "(");
                tempList.add(temp + ")");
            }
            rs.clear();
            rs.addAll(tempList);
        }
        rs.removeIf(s -> !isValid(s));
        return rs;
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
}
