package StackRevision;

import java.util.Stack;

public class validParanthesis {

    public static boolean validateParanthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                st.push(str.charAt(i));
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (str.charAt(i) == ')' && st.peek() != '(' || str.charAt(i) == '}' && st.peek() != '{'
                        || str.charAt(i) == ']' && st.peek() != '[') {
                    return false;
                }
                st.pop();
            }

        }
        return st.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String str = ")(";
        System.out.println(validateParanthesis(str));
    }
}
