package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackSpan {

    public static ArrayList<Integer> getStackSpan(int arr[]) {
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stk.empty()) {
                result.add(i + 1);
            } else {
                if (arr[i] < arr[stk.peek()] && !stk.empty()) {
                    result.add(i - stk.peek());
                } else {
                    while (!stk.empty() && (arr[i] >= arr[stk.peek()])) {
                        stk.pop();
                    }
                    if (stk.empty()) {
                        result.add(i + 1);
                    } else {
                        result.add(i - stk.peek());
                    }

                }
            }
            stk.push(i);

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 85, 100 };
        System.out.println(getStackSpan(arr));

    }

}
