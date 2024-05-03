package QueueTopic;

import java.util.Stack;

public class QueueUsing2Stack {
    static class Queue {
        static Stack<Integer> stk1 = new Stack<>();
        static Stack<Integer> stk2 = new Stack<>();

        public static boolean isEmpty() {
            return stk1.isEmpty();
        }

        public static void add(int data) {
            stk1.add(data);
            return;
        }

        public static int peek() {
            if (stk1.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return stk1.peek();
        }

        public static int remove() {
            if (stk1.empty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
            int data = stk2.pop();
            while (!stk2.isEmpty()) {
                stk1.push(stk2.pop());
            }
            return data;
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
