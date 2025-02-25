package StackRevision;

import java.util.Stack;

public class prefixToPostFix {
    public static boolean isOperator(char ch) {
        switch (ch) {
            case '^':
            case '/':
            case '*':
            case '+':
            case '-':
                return true;
        }
        return false;
    }

    public static String convertPrefixToPostFix(String str) {
        Stack<String> st = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (isOperator(str.charAt(i))) {
                String firstCharacter = st.pop();
                String secondCharacter = st.pop();
                String resullt = firstCharacter + secondCharacter + str.charAt(i);
                st.push(resullt);
            } else {
                st.push(str.charAt(i) + "");
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String str = "*+AB-CD";
        System.out.println(convertPrefixToPostFix(str));

    }

}
