package QueueTopic;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsiing2Queue {

    static class Stack {
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        public static boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        public static void push(int data) {
            if (!queue2.isEmpty()) {
                queue2.add(data);
            } else {
                queue1.add(data);
            }
            return;
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int top = -1;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    if (queue1.isEmpty()) {
                        break;
                    }
                    queue2.add(top);
                }
            } else {
                while (!queue2.isEmpty()) {
                    top = queue2.remove();
                    if (queue2.isEmpty()) {
                        break;
                    }
                    queue1.add(top);

                }
            }

            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int top = -1;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    queue2.add(top);
                }
            } else {
                while (!queue2.isEmpty()) {
                    top = queue2.remove();
                    queue1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack stk1 = new Stack();
        stk1.push(10);
        stk1.push(20);
        stk1.push(30);
        while (!stk1.isEmpty()) {
            System.out.println(stk1.pop());
        }
        System.out.println(stk1.peek());
        stk1.push(40);
        System.out.println(stk1.peek());

    }

}
