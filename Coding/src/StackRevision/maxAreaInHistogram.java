package StackRevision;

import java.util.Stack;

public class maxAreaInHistogram {

    public static void findNextSmallerArray(int height[]) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[height.length];
        result[height.length - 1] = height.length;
        for (int i = height.length - 2; i >= 0; i--) {
            int currentValue = height[i];
            if (st.isEmpty()) {
                st.push(i);
            }
        }
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };

    }

}
