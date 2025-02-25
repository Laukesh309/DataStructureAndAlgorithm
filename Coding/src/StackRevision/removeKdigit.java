package StackRevision;

import java.util.Stack;

public class removeKdigit {

    public static String removeKdigit(String str, int k) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            while (!st.isEmpty() && str.charAt(st.peek()) - '0' > str.charAt(i) - '0' && k > 0) {
                st.pop();
                k--;
            }
            st.push(i);
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) {
            return "0";
        }
        String result = "";
        while (!st.isEmpty()) {
            result = str.charAt(st.peek()) + result;
            st.pop();
        }
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }
        if (result.substring(i, result.length()).isEmpty()) {
            return "0";
        } else {
            return result.substring(i, result.length());
        }

    }

    public static void main(String[] args) {
        String str = "10200";
        int k = 1;
        String result = removeKdigit(str, k);
        System.out.println(result);

    }

}
