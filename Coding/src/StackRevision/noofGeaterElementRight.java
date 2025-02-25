//https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-nges-to-the-right

package StackRevision;

import java.util.Stack;

public class noofGeaterElementRight {

    public static int[] findGreaterElement(int arr[], int queries, int indices[]) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = st.size();
            }
            st.push(i);
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
        int finalResult[] = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            finalResult[i] = result[indices[i]];
        }
        System.out.println();
        for (int i : finalResult) {
            System.out.println(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int queries = 2;
        int indices[] = { 0, 5 };
        findGreaterElement(arr, queries, indices);

    }

}
