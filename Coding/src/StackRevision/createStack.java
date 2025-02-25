package StackRevision;

import java.util.ArrayList;

public class createStack {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            if (list.size() == 0) {
                return true;
            }
            return false;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int peek() {
            return list.get(list.size() - 1);
        }

        public static int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.list);

    }

}
