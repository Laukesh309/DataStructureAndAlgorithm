package Stack;

import java.util.Stack;

public class pushBottom {

    public static void pushBottomNumber(Stack<Integer> stk, int data) {
        if (stk.empty()) {
            stk.push(data);
            return;
        }
        int currentData = stk.pop();
        pushBottomNumber(stk, data);
        stk.push(currentData);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        int data = 90;
        pushBottomNumber(stk, data);
        System.out.println(stk);
    }

}
