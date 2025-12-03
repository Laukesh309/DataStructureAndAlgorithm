package String;

import java.util.Stack;

import LinkedList.LinkList;

public class removeOuterParanthesis {

    public static String getModifiedString(String str) {

        String result = "";
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                start++;
                if (start > 1) {
                    result = result + ch;
                }
            } else {
                if (start != 1) {
                    result = result + ch;
                }
                start--;
            }
        }
        return result;

    }

    public static void findValidString(String str) {
        Stack<Character> st = new Stack<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                if (!st.empty()) {
                    result = result + ch;
                }
                st.push(ch);
            } else {
                if (st.size() != 1) {
                    result = result + ch;
                }
                st.pop();
            }

        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "(()())(())(()(()))";
        System.out.println(getModifiedString(str));

    }

}
