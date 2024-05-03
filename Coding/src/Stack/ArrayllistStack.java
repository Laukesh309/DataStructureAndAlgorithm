package Stack;

import java.util.ArrayList;

public class ArrayllistStack {

    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push operation
        public static void push(int data) {
            list.add(data);
        }

        // pop operation
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek element
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
        System.out.println(stack.isEmpty());
    }

}
