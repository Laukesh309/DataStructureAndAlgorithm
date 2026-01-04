package TwoPointer;

import java.util.Arrays;

public class reverWord {

    public static void printArray(char sArray[]) {
        for (char c : sArray) {
            System.out.print(c + "");
        }
        System.out.println();
    }

    public static void reverseWord(String s) {
        char sArray[] = s.toCharArray();
        int firstIndex = 0;
        int lastIndex = sArray.length - 1;
        while (firstIndex < lastIndex) {
            if (sArray[firstIndex] == ' ') {
                firstIndex++;
                continue;
            } else if (sArray[lastIndex] == ' ') {
                lastIndex--;
                continue;
            } else {
                char temp = sArray[firstIndex];
                sArray[firstIndex] = sArray[lastIndex];
                sArray[lastIndex] = temp;
            }

            firstIndex++;
            lastIndex--;
        }
        printArray(sArray);
        String result = String.valueOf(sArray);

        System.out.println(result);

    }

    public static void main(String[] args) {
        String s = "Help others";
        reverseWord(s);
    }

}
