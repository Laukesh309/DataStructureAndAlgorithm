package StackRevision;

import java.util.Stack;

import LinkedListRevision.addOne;

public class Calculator {

    public static void findCalculator(String s) {
        Stack<Integer> st = new Stack<>();
        int currentIndex = 0;
        int ans = 0;
        int prevSign = 1;
        while (currentIndex < s.length()) {
            char curChar = s.charAt(currentIndex);
            if (Character.isDigit(curChar)) {
                int prevAns = curChar - '0';
                while (currentIndex + 1 < s.length() && Character.isDigit(s.charAt(currentIndex + 1))) {
                    prevAns = prevAns * 10 + s.charAt(currentIndex + 1) - '0';
                    currentIndex++;
                }
                ans = ans + prevAns * prevSign;
            } else if (curChar == '+') {
                prevSign = 1;
            } else if (curChar == '-') {
                prevSign = -1;
            } else if (curChar == '(') {
                st.push(ans);
                st.push(prevSign);
                ans = 0;
                prevSign = 1;
            } else if (curChar == ')') {
                int currentSign = st.pop();
                int currentAns = st.pop();
                ans = currentAns + currentSign * ans;
            }
            currentIndex++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        findCalculator(s);

    }

}
