package 栈相关.q224_基本计算器.f1;

import java.util.Stack;

/**
 * 双栈（操作数栈+操作符栈）o(n)
 */
public class Solution {

    public int calculate(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        int temp = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == ' ') {
                continue;
            }
            // 数字进行累加
            if (isNumber(array[i])) {
                if (temp == -1) {
                    temp = array[i] - '0';
                } else {
                    temp = temp * 10 + array[i] - '0';
                }
            } else {
                //将数字入栈
                if (temp != -1) {
                    num.push(temp);
                    temp = -1;
                }
                //遇到操作符
                if (isOperation(array[i] + "")) {
                    while (!op.isEmpty()) {
                        if (op.peek() == '(') {
                            break;
                        }
                        //不停的出栈，进行运算，并将结果再次压入栈中
                        int num1 = num.pop();
                        int num2 = num.pop();
                        if (op.pop() == '+') {
                            num.push(num1 + num2);
                        } else {
                            num.push(num2 - num1);
                        }

                    }
                    //当前运算符入栈
                    op.push(array[i]);
                } else {
                    //遇到左括号，直接入栈
                    if (array[i] == '(') {
                        op.push(array[i]);
                    }
                    //遇到右括号，不停的进行运算，直到遇到左括号
                    if (array[i] == ')') {
                        while (op.peek() != '(') {
                            int num1 = num.pop();
                            int num2 = num.pop();
                            if (op.pop() == '+') {
                                num.push(num1 + num2);
                            } else {
                                num.push(num2 - num1);
                            }
                        }
                        op.pop();
                    }

                }
            }
        }
        if (temp != -1) {
            num.push(temp);
        }
        //将栈中的其他元素继续运算
        while (!op.isEmpty()) {
            int num1 = num.pop();
            int num2 = num.pop();
            if (op.pop() == '+') {
                num.push(num1 + num2);
            } else {
                num.push(num2 - num1);
            }
        }
        return num.pop();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }
}
