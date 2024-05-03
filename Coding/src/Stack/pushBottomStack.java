package Stack;

import java.util.Stack;

public class pushBottomStack {

    public static void pushDataOnBottomStack(Stack<Integer> stk, int data) {
        if (stk.isEmpty()) {
            stk.push(data);
            return;
        }
        int top = stk.pop();
        pushDataOnBottomStack(stk, data);
        stk.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        pushDataOnBottomStack(stk, 40);
        System.out.println(stk);
    }

}
