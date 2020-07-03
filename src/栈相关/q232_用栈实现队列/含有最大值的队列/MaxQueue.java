package 栈相关.q232_用栈实现队列.含有最大值的队列;

import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> queue;
    private LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.size() == 0 ? -1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (max.size() != 0 && max.getLast() < value) {
            max.removeLast();
        }
        max.add(value);
    }

    public int pop_front() {
        if (max.size() != 0 && queue.peek().equals(max.getFirst())) {
            max.removeFirst();
        }
        return queue.size() == 0 ? -1 : queue.poll();
    }
}
