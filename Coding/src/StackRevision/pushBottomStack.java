package StackRevision;

import java.util.Stack;

public class pushBottomStack {

    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> temp = new Stack<>();

    public static void pushBottom(int data) {
        if (st.isEmpty()) {
            st.push(data);
        } else {
            while (!st.isEmpty()) {
                int top = st.pop();
                temp.push(top);
            }
            st.push(data);
            while (!temp.isEmpty()) {
                st.push(temp.pop());
            }
        }

    }

    public static void pushBottomRecursion(int data) {
        if (st.isEmpty()) {
            st.push(data);
            return;
        }
        int top = st.pop();
        pushBottom(data);
        st.push(top);
        return;
    }

    public static void main(String[] args) {
        pushBottomRecursion(10);
        pushBottomRecursion(20);
        pushBottomRecursion(30);
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

}
