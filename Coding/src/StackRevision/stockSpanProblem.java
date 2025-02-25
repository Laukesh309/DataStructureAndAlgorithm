package StackRevision;

import java.util.Stack;

public class stockSpanProblem {

    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 85, 100 };
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                result[i] = 1;
            } else {
                while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    result[i] = i + 1;
                } else {
                    result[i] = i - st.peek();
                }

            }
            st.push(i);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

}
