package QueueTopic;

import java.util.Deque;
import java.util.LinkedList;

public class QueueDeque {

    static class Queue {

        static Deque<Integer> deque = new LinkedList();

        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        public static void add(int data) {
            deque.addLast(data);
        }

        public static int remove() {
            return deque.removeFirst();
        }

        public static int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue newQueue = new Queue();
        newQueue.add(10);
        newQueue.add(20);
        newQueue.add(30);
        while (!newQueue.isEmpty()) {
            System.out.println(newQueue.remove());

        }

    }

}
