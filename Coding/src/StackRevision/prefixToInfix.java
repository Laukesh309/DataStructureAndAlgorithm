package StackRevision;

import java.util.Stack;

public class prefixToInfix {

    public static String convertPrefixToInfix(String str) {
        Stack<String> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != '^' && str.charAt(i) != '/' && str.charAt(i) != '*' && str.charAt(i) != '+'
                    && str.charAt(i) != '-') {
                st.push(str.charAt(i) + "");
            } else {
                String firstCharacter = st.pop();
                String secondCharacter = st.pop();
                String result = "(" + firstCharacter + str.charAt(i) + secondCharacter + ")";
                st.push(result);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String str = "*+AB-CD";
        System.out.println(convertPrefixToInfix(str));
    }

}
