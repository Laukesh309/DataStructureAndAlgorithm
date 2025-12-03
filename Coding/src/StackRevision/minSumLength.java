package StackRevision;

import java.util.Stack;

public class minSumLength {

    public static void findPrevMin(int arr[], int prevMin[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] > currentElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevMin[i] = -1;
            } else {
                prevMin[i] = st.peek();
            }
            st.push(i);
        }

    }

    public static void findNextMin(int arr[], int nextMin[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] > currentElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextMin[i] = arr.length;
            } else {
                nextMin[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 4 };
        int ans = 0;
        int prevMin[] = new int[arr.length];
        int nextMin[] = new int[arr.length];
        findPrevMin(arr, prevMin);
        findNextMin(arr, nextMin);
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int prevLength = i - prevMin[i];
            int nextLength = nextMin[i] - i;
            int totalSubSet = prevLength * nextLength;
            total = total + totalSubSet * arr[i];

        }
        System.out.println(total);

    }

}
