package QueueTopic;

import java.util.Deque;
import java.util.LinkedList;

public class queueUsingDeque2 {

    static class Queue {
        static Deque<Integer> deque = new LinkedList<>();

        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        public static void add(int data) {
            deque.addFirst(data);
            return;
        }

        public static int peek() {
            if (deque.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return deque.getFirst();
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

}
