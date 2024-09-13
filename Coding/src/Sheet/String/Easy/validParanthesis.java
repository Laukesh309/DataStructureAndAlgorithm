package Sheet.String.Easy;

import java.util.Stack;

public class validParanthesis {

    public static boolean checkValidParanthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                st.push(str.charAt(i));
            } else {
                if (st.size() > 0 && str.charAt(i) == ')' && st.peek() == '(') {
                    st.pop();
                } else if (st.size() > 0 && str.charAt(i) == '}' && st.peek() == '{') {
                    st.pop();
                } else if (st.size() > 0 && str.charAt(i) == ']' && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }

            }

        }
        return st.isEmpty();

    }

    public static void main(String[] args) {
        String str = "]";
        System.out.println(checkValidParanthesis(str));

    }

}