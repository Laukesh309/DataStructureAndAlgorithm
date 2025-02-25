package StackRevision;

import java.util.Stack;

public class dublicateParanthesis {

    public static boolean findDublicate(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != ')') {
                st.push(currentChar);
            } else {
                int counter = 0;
                while (st.peek() != '(') {
                    st.pop();
                    counter++;
                }
                if (counter == 0) {
                    return true;
                }
                st.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(findDublicate(str));
    }

}
