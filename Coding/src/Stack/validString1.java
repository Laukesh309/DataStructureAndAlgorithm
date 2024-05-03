package Stack;

import java.util.Stack;

public class validString1 {
    public static boolean checkValidString(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentCharater = str.charAt(i);
            if (currentCharater == '(' || currentCharater == '{' || currentCharater == '[') {
                stk.push(currentCharater);
            } else {

                if (!stk.empty() && ((stk.peek() == '(' && currentCharater == ')')
                        || (stk.peek() == '{' && currentCharater == '}')
                        || (stk.peek() == '[' && currentCharater == ']'))) {
                    stk.pop();
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        String str2 = "({[]}())";
        String str3 = "{([)}";
        String str4 = "}}}}";
        System.out.println(checkValidString(str3));
    }

}
