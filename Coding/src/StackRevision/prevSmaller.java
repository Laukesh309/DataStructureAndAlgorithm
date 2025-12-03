package StackRevision;

import java.util.ArrayList;
import java.util.Stack;

public class prevSmaller {
    public static void main(String[] args) {
        int arr[] = { 1, 6, 2 };
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int curElement = arr[i];
            while (!st.isEmpty() && st.peek() >= curElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                result.add(-1);
            } else {
                result.add(st.peek());
            }
            st.push(curElement);

        }
        System.out.println(result);
    }

}
