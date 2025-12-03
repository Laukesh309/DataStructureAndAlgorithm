package String;

import java.util.Arrays;

public class LongestPrefix {

    public static void main(String[] args) {
        String strs[] = { "reflower", "flow", "flight" };

        Arrays.sort(strs);
        for (String string : strs) {
            System.out.println(string);
        }
        String result = "";
        int initialPointer = 0;
        String str1 = strs[0];
        String str2 = strs[1];
        while (initialPointer < str1.length() && initialPointer < str2.length()) {
            if (str1.charAt(initialPointer) != str2.charAt(initialPointer)) {
                break;
            }
            result = result + str1.charAt(initialPointer);
            initialPointer++;

        }
        System.out.println(result);
    }

}
