package Stack;

import java.util.Stack;

public class collectionStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(90);

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.isEmpty());
    }

}
