package StackRevision;

import java.util.Stack;

public class minStack {

    static Stack<Integer> st;
    static Stack<Integer> minValue;

    public minStack() {
        st = new Stack<>();
        minValue = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            minValue.push(val);
        } else {
            if (minValue.peek() > val) {
                minValue.push(val);
            } else {
                minValue.push(minValue.peek());
            }
        }
        st.push(val);

    }

    public void pop() {
        st.pop();
        minValue.pop();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minValue.peek();

    }

    public static int OptimiseSolution

    public static void main(String[] args) {
        minStack ms = new minStack();
        ms.push(-1);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }

}
