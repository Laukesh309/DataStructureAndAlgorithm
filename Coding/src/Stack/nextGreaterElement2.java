package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class nextGreaterElement2 {

    public static void nextGreaterElementImple(int arr[]) {
        int result[] = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stk.empty() && arr[i] >= stk.peek()) {
                stk.pop();
            }
            if (stk.empty()) {
                result[i] = -1;
            } else {
                result[i] = stk.peek();
            }
            stk.push(arr[i]);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static void main(String[] args) {

        int arr[] = { 6, 8, 0, 1, 3 };
        nextGreaterElementImple(arr);
    }

}
