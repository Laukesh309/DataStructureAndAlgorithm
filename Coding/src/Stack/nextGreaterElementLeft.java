package Stack;

import java.util.Stack;

public class nextGreaterElementLeft {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void nextGreateElementLeftImp(int arr[]) {
        int result[] = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
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
        printArray(result);

    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        nextGreateElementLeftImp(arr);
    }

}
