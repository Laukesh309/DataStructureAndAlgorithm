package QueueTopic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueueStack {

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stk = new Stack<>();
        while (!queue.isEmpty()) {
            stk.push(queue.remove());
        }
        while (!stk.isEmpty()) {
            queue.add(stk.pop());

        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        reverseQueue(queue);
        System.out.println(queue);
    }

}
