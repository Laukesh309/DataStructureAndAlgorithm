package StackRevision;

import java.util.Stack;

public class reverseStringUsingStack {

    static Stack<Character> st = new Stack<>();

    public static void pushBottom(char ch) {
        if (st.isEmpty()) {
            st.push(ch);
            return;
        }
        char currentChar = st.pop();
        pushBottom(ch);
        st.push(currentChar);
    }

    public static void main(String[] args) {
        String str = "laukesh";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }
        StringBuilder str2 = new StringBuilder();

        while (!st.isEmpty()) {
            str2.append(st.pop());
        }
        str = str2.toString();
        System.out.println(str);
        // System.out.println(st);

    }

}
