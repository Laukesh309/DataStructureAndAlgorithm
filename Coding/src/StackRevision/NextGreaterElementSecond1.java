package StackRevision;

import java.util.Stack;

public class NextGreaterElementSecond1 {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 3 };
        Stack<Integer> st = new Stack<>();
        int result[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int curElement = nums[i];
            while (!st.isEmpty() && st.peek() <= curElement) {
                st.pop();
            }
            st.push(curElement);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int curElement = nums[i];
            while (!st.isEmpty() && st.peek() <= curElement) {
                st.pop();
            }
            if (st.empty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(curElement);
        }
        return result;
    }

}
