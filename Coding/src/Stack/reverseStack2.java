package Stack;

import java.util.Stack;

public class reverseStack2 {

    public static void pushDataBottom(Stack<Integer> stk, int currentData) {
        if (stk.empty()) {
            stk.push(currentData);
            return;
        }
        int currentStackData = stk.pop();
        pushDataBottom(stk, currentData);
        stk.push(currentStackData);
        return;

    }

    public static void reverseStckImplementation(Stack<Integer> stk) {
        if (stk.empty()) {
            return;
        }
        int currentData = stk.pop();
        reverseStckImplementation(stk);
        pushDataBottom(stk, currentData);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        reverseStckImplementation(stk);
        System.out.println(stk);
    }

}
