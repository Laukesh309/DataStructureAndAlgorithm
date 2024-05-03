package Stack;

import java.util.Stack;

public class reverseStack {

    public static void placeAtBottom(Stack<Integer> stk, int data) {
        if (stk.empty()) {
            stk.push(data);
            return;
        }
        int top = stk.pop();
        placeAtBottom(stk, data);
        stk.push(top);

    }

    public static void reverseStackImplentation(Stack<Integer> stk) {
        if (stk.isEmpty()) {
            return;
        }
        int top = stk.pop();
        reverseStackImplentation(stk);
        placeAtBottom(stk, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        System.out.println(stk);
        reverseStackImplentation(stk);
        System.out.println(stk);
    }

}
