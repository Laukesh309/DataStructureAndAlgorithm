package Stack;

import java.util.Stack;

public class validParenthesis {

    public static boolean checkValidParanthesis(String str) {
        Stack<Character> stc = new Stack<>();
        int initialIndex = 0;
        while (initialIndex < str.length()) {
            char currentCharater = str.charAt(initialIndex);
            if (currentCharater == '(' || currentCharater == '{' || currentCharater == '[') {
                stc.push(currentCharater);
            } else {
                char top = stc.peek();
                if ((top == '(' && currentCharater == ')') || (top == '{' && currentCharater == '}')
                        || (top == '[' && currentCharater == ']')) {
                    stc.pop();
                } else {
                    return false;
                }
            }
            initialIndex++;
        }
        return stc.isEmpty();
    }

    public static void main(String[] args) {
        String str = "(){}";
        System.out.println(checkValidParanthesis(str));
    }

}
