package QueueTopic;

import java.util.LinkedList;
import java.util.Queue;

public class queueInterleave {

    public static void interLeaveElement(Queue<Integer> queue) {
        int size = queue.size() / 2;
        Queue<Integer> secondQueue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            secondQueue.add(queue.remove());
        }
        while (!secondQueue.isEmpty()) {
            queue.add(secondQueue.remove());
            queue.add(queue.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(i * 10);
        }
        interLeaveElement(queue);
        System.out.println(queue);

    }

}
