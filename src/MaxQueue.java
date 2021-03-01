import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author AndrewElvis
 * @date 2020-09-28-19:37
 * @description
 */
class MaxQueue {
    public static void main(String[] args) {
        
    }

    Deque<Integer> deque;
    Deque<Integer> help;

    public MaxQueue() {
        deque = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        if(deque.isEmpty()) return -1;
        return help.peek();
    }

    public void push_back(int value) {
        deque.offer(value);
        while(!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if(deque.isEmpty()) return -1;

        if(deque.peek() == help.peek()) {
            help.pop();
        }
        int val = deque.pop();
        return val;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
