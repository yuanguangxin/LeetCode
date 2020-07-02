package 栈相关.q232_用栈实现队列.f1;

import java.util.Stack;

/**
 * 双栈 入队o(n) 出队o(1)
 */
class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private Integer front;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()){
            front = x;
        }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int value = s1.pop();
        if (!s1.empty()){
            front = s1.peek();
        }
        return value;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
