package QueueTopic;

import java.util.Deque;
import java.util.LinkedList;

public class queueUsingDeque1 {

    static class Stack {
        static Deque<Integer> deque = new LinkedList<>();

        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        public static void push(int data) {
            deque.addLast(data);
            return;
        }

        public static int pop() {
            return deque.removeLast();
        }

        public static int peek() {
            return deque.getLast();
        }
    }

    public static void main(String[] args) {

        Stack stk = new Stack();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        while (!stk.isEmpty()) {
            System.out.println(stk.pop());

        }

    }

}
