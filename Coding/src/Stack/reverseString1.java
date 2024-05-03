package Stack;

import java.util.Stack;

public class reverseString1 {

    public static String reverseStringImp(String str) {

        Stack<Character> stk = new Stack<>();
        int intitialIndex = 0;
        while (intitialIndex < str.length()) {
            stk.push(str.charAt(intitialIndex));
            intitialIndex++;
        }
        StringBuilder newString = new StringBuilder("");
        while (!stk.empty()) {
            char ch = stk.pop();
            newString.append(ch);
        }
        return newString.toString();

    }

    public static void main(String[] args) {
        String str = "laukesh";
        System.out.println(reverseStringImp(str));

    }

}
