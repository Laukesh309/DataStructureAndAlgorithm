package StackRevision;

import java.util.Stack;

public class LongestHistogram {

    public static void findPrevMin(int heights[], int prevMax[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int curElement = heights[i];
            while (!st.isEmpty() && heights[st.peek()] >= curElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevMax[i] = -1;
            } else {
                prevMax[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void findNextMin(int heights[], int nextMax[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            int curElement = heights[i];
            while (!st.isEmpty() && heights[st.peek()] >= curElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextMax[i] = heights.length;
            } else {
                nextMax[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void printValue(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        int prevMax[] = new int[heights.length];
        int nextMax[] = new int[heights.length];
        findPrevMin(heights, prevMax);
        printValue(prevMax);
        findNextMin(heights, nextMax);
        printValue(nextMax);
        int totalResult = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int totalWidth = nextMax[i] - prevMax[i] - 1;
            int currentHeight = heights[i];
            totalResult = Math.max(totalResult, currentHeight * totalWidth);

        }

        System.out.println(totalResult);
    }

}
