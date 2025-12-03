package StackRevision;

import java.util.Stack;

public class BalanceParanthesis {

    public static boolean checkBalance(String s) {
        Stack<Character> st = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char curchar = s.charAt(index);
            if (curchar != '(' && curchar != '{' && curchar != '[') {
                if (!st.isEmpty() && curchar == ')' && st.peek() == '(' || curchar == ']' && st.peek() == '['
                        || curchar == '}' && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(curchar);
            }
            index++;
        }
        return st.empty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(checkBalance(s));

    }

}
