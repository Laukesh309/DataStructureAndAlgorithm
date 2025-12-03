package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class stockSpanproblem {

    public static void findPrevMin(int arr[], int prevMin[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] <= currentElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                prevMin[i] = -1;
            } else {
                prevMin[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 100, 80, 90, 120 };
        int prevMin[] = new int[arr.length];
        findPrevMin(arr, prevMin);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(i - prevMin[i]);
        }

        System.out.println(result);
    }

}
