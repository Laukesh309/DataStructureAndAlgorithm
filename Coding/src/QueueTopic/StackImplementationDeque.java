package QueueTopic;

import java.util.Deque;
import java.util.LinkedList;

public class StackImplementationDeque {

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
            if (deque.isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }
            return deque.removeLast();
        }

        public static int peek() {
            if (deque.isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }
            return deque.getLast();
        }

    }

    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        System.out.println(stk.peek());

    }

}
