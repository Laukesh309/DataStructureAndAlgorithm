package Stack;

import java.util.Stack;

public class simplyfiedPath {

    public static void findPath(String path) {
        Stack<String> tempStack = new Stack<>();
        String tempString[] = path.split("/");
        for (int i = 0; i < tempString.length; i++) {
            String temp = tempString[i];
            if (temp.equals("..")) {
                if (!tempStack.isEmpty()) {
                    tempStack.pop();
                }
                continue;
            } else if (temp.equals(".") || temp.isEmpty()) {
                continue;
            } else {
                tempStack.push(temp);
            }
        }
        String result = new String();
        while (!tempStack.isEmpty()) {
            String curString = tempStack.pop();
            result = "\\" + curString + result;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String path = "/../";
        findPath(path);
    }

}
