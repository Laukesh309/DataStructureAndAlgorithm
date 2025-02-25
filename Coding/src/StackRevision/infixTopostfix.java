package StackRevision;

import java.util.HashMap;
import java.util.Stack;

public class infixTopostfix {

    public static String convertPostFix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('^', 1);
        hm.put('/', 2);
        hm.put('*', 2);
        hm.put('+', 3);
        hm.put('-', 3);
        hm.put('(', 0);
        hm.put(')', 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '^' && s.charAt(i) != '*' && s.charAt(i) != '+' && s.charAt(i) != '-'
                    && s.charAt(i) != '/'
                    && s.charAt(i) != '(' && s.charAt(i) != ')') {
                result.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && hm.get(st.peek()) <= hm.get(s.charAt(i)) && st.peek() != '(') {
                    char top = st.pop();
                    result.append(top);
                }
                st.push(s.charAt(i));
            }

        }
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(a+b)*(c+d)";
        System.out.println(convertPostFix(s));
    }

}
