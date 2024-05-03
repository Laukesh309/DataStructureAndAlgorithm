package Stack;

import java.util.Stack;

public class DublicateParanthesis {

    public static boolean findDublicateParanthesis(String str) {
        int inititalIndex = 0;
        Stack<Character> stc = new Stack<>();
        while (inititalIndex < str.length()) {
            char currentCharater = str.charAt(inititalIndex);
            if (currentCharater == ')') {
                int count = 0;
                while (stc.peek() != '(') {
                    count++;
                    System.out.println(stc);
                    stc.pop();
                }
                if (count < 1) {
                    return true;
                } else {
                    stc.pop();
                }

            } else {
                stc.push(currentCharater);
            }
            inititalIndex++;
        }
        return false;
    }

    public static void main(String[] args) {
        // String str = "((a+b)+(c+d))";
        // String str = "(((a+b))+c)";
        String str = "((((a)+(b))+c+d))";
        System.out.println(findDublicateParanthesis(str));
    }

}
