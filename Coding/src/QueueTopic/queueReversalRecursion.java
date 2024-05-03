package QueueTopic;

import java.util.LinkedList;
import java.util.Queue;

public class queueReversalRecursion {

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int data = queue.remove();
        reverseQueue(queue);
        queue.add(data);
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
