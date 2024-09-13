package Sheet.String.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class printAllDublicateString {

    public static void printAllDublicateElement(String str) {

        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        String sortedArray = new String(strArr);
        System.out.println(sortedArray);
        int currentIndex = 0;
        while (currentIndex < sortedArray.length()) {
            char currentChar = sortedArray.charAt(currentIndex++);
            int counter = 1;
            while (currentIndex < sortedArray.length()
                    && sortedArray.charAt(currentIndex) == sortedArray.charAt(currentIndex - 1)) {
                counter++;
                currentIndex++;
            }
            if (counter >= 2) {
                System.out.println(currentChar + " " + counter);
            }

        }
    }

    public static void countDublicateElement(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
        }
        System.out.println(hm);
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        countDublicateElement(str);
        printAllDublicateElement(str);

    }

}
