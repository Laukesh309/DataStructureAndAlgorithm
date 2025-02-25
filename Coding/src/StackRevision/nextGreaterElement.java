package StackRevision;

import java.util.Stack;

public class nextGreaterElement {

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        result[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            int currentElemnt = arr[i];
            while (!st.isEmpty() && currentElemnt > st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
