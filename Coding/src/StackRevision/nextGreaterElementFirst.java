package StackRevision;

import java.util.Stack;

public class nextGreaterElementFirst {

    public static int[] findNextGreaterElement(int nums2[]) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[st.peek()] <= nums2[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = nums2[st.peek()];
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 4 };
        int nums2[] = { 1, 2, 3, 4 };
        int result[] = new int[nums2.length];
        int finalResult[] = new int[nums1.length];
        result = findNextGreaterElement(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int currentElement = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == currentElement) {
                    finalResult[i] = result[j];
                    break;
                }
            }
        }
        for (int i : finalResult) {
            System.out.print(i + " ");
        }

    }

}
