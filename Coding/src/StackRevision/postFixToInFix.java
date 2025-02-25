package StackRevision;

import java.util.Stack;

public class postFixToInFix {

    public static String convertPostFix(String exp) {

        Stack<String> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != '^' && exp.charAt(i) != '*' && exp.charAt(i) != '+' && exp.charAt(i) != '/'
                    && exp.charAt(i) != '-') {
                st.push("" + exp.charAt(i));
            } else {
                String secondElement = st.pop();
                String firstElement = st.pop();
                String result = "(" + firstElement + exp.charAt(i) + secondElement + ")";
                st.push(result);
            }
        }

        return st.pop();

    }

    public static void main(String[] args) {
        String s = "ab*c+";
        System.out.println(convertPostFix(s));
    }

}
