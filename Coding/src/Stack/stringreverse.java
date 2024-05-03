package Stack;

import java.util.Stack;

public class stringreverse {

    public static String reverseString(String str) {
        Stack<Character> ch = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            ch.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!ch.isEmpty()) {
            result.append(ch.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Hello World";
        String result = reverseString(str);
        System.err.println(result);
    }

}
