package StackRevision;

import java.util.Stack;

public class reverseStack {

    static Stack<Integer> st = new Stack<>();

    public static void pushBottom(int data) {
        if (st.isEmpty()) {
            st.push(data);
            return;
        }

    }

    public static void main(String[] args) {
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        for (int i = 0; i < st.size(); i++) {

        }

    }

}
