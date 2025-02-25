
// https://leetcode.com/problems/sum-of-subarray-minimums/description/

package StackRevision;

import java.util.Stack;

public class sumOfSubArrayMin {

    public static void findPrevGreater(int arr[], int prevGreater[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            while (!st.isEmpty() && currentElement <= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevGreater[i] = -1;
            } else {
                prevGreater[i] = st.peek();
            }
            st.push(i);

        }
        return;

    }

    public static void findNextGreater(int arr[], int nextGreater[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int currentElement = arr[i];
            while (!st.empty() && currentElement < arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextGreater[i] = arr.length;
            } else {
                nextGreater[i] = st.peek();
            }
            st.push(i);
        }
        return;

    }

    public static void main(String[] args) {
        int arr[] = { 71, 55, 82, 55 };
        int nextGreater[] = new int[arr.length];
        int prevGreater[] = new int[arr.length];
        int mod = 1000000007;
        findNextGreater(arr, nextGreater);
        findPrevGreater(arr, prevGreater);
        long minValue = 0;
        for (int i = 0; i < arr.length; i++) {
            long prevRange = i - prevGreater[i];
            long nextRange = nextGreater[i] - i;
            long totalValue = (((prevRange * nextRange) % mod) * arr[i]) % mod;
            minValue = (minValue + totalValue) % mod;
        }
        System.out.println(minValue);
    }

}
