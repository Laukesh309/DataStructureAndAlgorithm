package StackRevision;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void printArray(int element[]) {
        for (int i : element) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findNextMax(int heights[], int nextSmaller[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextSmaller[i] = heights.length;
            } else {
                nextSmaller[i] = st.peek();
            }
            st.push(i);
        }
        printArray(nextSmaller);
    }

    public static void findprevMax(int heights[], int prevSmaller[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }
            st.push(i);
        }
        printArray(prevSmaller);

    }

    public static int findMaxArea(int heights[], int prevSmaller[], int nextSmaller[]) {
        int maximumArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            int currentWidth = nextSmaller[i] - prevSmaller[i] - 1;
            int currentArea = currentHeight * currentWidth;
            maximumArea = Math.max(maximumArea, currentArea);
        }
        return maximumArea;
    }

    public static void main(String[] args) {
        int heights[] = { 4, 2, 0, 3, 2, 4, 3, 4 };
        int prevSmaller[] = new int[heights.length];
        int nextSmaller[] = new int[heights.length];
        findNextMax(heights, nextSmaller);
        findprevMax(heights, prevSmaller);
        System.out.println(findMaxArea(heights, prevSmaller, nextSmaller));

    }

}
