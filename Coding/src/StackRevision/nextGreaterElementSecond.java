//https://leetcode.com/problems/next-greater-element-ii/description/

package StackRevision;

import java.util.Stack;

public class nextGreaterElementSecond {

    public static int[] findResult(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = 2 * arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek() % arr.length] <= arr[i % arr.length]) {
                st.pop();
            }
            if (i < arr.length) {
                if (st.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = arr[st.peek() % arr.length];
                }
            }
            st.push(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };

        int result[] = findResult(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
