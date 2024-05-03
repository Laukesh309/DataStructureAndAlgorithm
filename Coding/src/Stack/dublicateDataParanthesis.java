package Stack;

import java.util.Stack;

public class dublicateDataParanthesis {

    public static boolean findValidParanthesis(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if (currentCharacter != ')') {
                stk.push(currentCharacter);
            } else {
                int count = 0;
                while (!stk.empty() && stk.peek() != '(') {
                    stk.pop();
                    count++;

                }
                if (count >= 1) {
                    stk.pop();
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(((a+(b)))+(c+d))";
        String str2 = "((a+b)+(c+d))";
        String str3 = "(((a+b))+c)";
        System.out.println(findValidParanthesis(str3));
    }

}
