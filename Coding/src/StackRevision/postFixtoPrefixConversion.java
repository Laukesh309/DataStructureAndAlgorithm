package StackRevision;

import java.util.Stack;

public class postFixtoPrefixConversion {

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

    public static String convertPostFixToPrefix(String str) {

        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (isOperator(str.charAt(i))) {
                String firstCharacter = st.pop();
                String secondCharacter = st.pop();
                String result = str.charAt(i) + secondCharacter + firstCharacter;
                st.push(result);

            } else {
                st.push(str.charAt(i) + "");
            }

        }
        return st.pop();

    }

    public static void main(String[] args) {
        String str = "AB+CD-*";
        System.out.println(convertPostFixToPrefix(str));
    }

}
