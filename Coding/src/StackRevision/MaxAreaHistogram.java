package StackRevision;

import java.util.Stack;

public class MaxAreaHistogram {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findRightSmaller(int arr[], int rightResult[]) {
        rightResult[arr.length - 1] = arr.length;
        Stack<Integer> st = new Stack<>();
        st.add(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rightResult[i] = arr.length;
            } else {
                rightResult[i] = st.peek();
            }
            st.add(i);
        }
        printArray(rightResult);
    }

    public static void findleftSmaller(int arr[], int leftResult[]) {
        leftResult[0] = -1;
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                leftResult[i] = -1;
            } else {
                leftResult[i] = st.peek();
            }
            st.add(i);
        }
        // printArray(leftResult);
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        int leftResult[] = new int[height.length];
        int rightResult[] = new int[height.length];
        findleftSmaller(height, leftResult);
        findRightSmaller(height, rightResult);
        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int leftArea = (i - leftResult[i]) * height[i];
            int rightArea = (rightResult[i] - i) * height[i];
            int currentArea = 1 * height[i];
            int totalArea = leftArea + rightArea - currentArea;
            maxResult = Math.max(maxResult, totalArea);
        }
        System.out.println(maxResult);
    }

}
