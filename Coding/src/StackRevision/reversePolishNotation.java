package StackRevision;

import java.util.Stack;

public class reversePolishNotation {

    public static int getResult(String arr[]) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+")) {
                int firstLetter = st.pop();
                int sececondLetter = st.pop();
                st.add(firstLetter + sececondLetter);

            } else if (arr[i].equals("-")) {
                int firstLetter = st.pop();
                int sececondLetter = st.pop();
                st.add(sececondLetter - firstLetter);

            } else if (arr[i].equals("*")) {
                int firstLetter = st.pop();
                int sececondLetter = st.pop();
                st.add(firstLetter * sececondLetter);

            } else if (arr[i].equals("/")) {
                int firstLetter = st.pop();
                int sececondLetter = st.pop();
                st.add(sececondLetter / firstLetter);

            } else {
                st.add(Integer.parseInt(arr[i]));
            }
        }
        System.out.println(st);
        return st.peek();
    }

    public static void main(String[] args) {
        String arr[] = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(getResult(arr));

    }

}
