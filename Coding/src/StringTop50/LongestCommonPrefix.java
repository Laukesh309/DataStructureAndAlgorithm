package StringTop50;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
        Arrays.sort(arr);
        if (arr.length == 0) {
            System.out.println("");
            return;
        }
        if (arr.length == 1) {
            System.out.println(arr[0]);
        }
        String first = arr[0];
        String last = arr[arr.length - 1];
        int inititalPointer = 0;
        String result = "";
        while (inititalPointer < first.length() && inititalPointer < last.length()) {
            if (first.charAt(inititalPointer) != last.charAt(inititalPointer)) {
                break;
            }
            result = result + first.charAt(inititalPointer);
            inititalPointer++;
        }

        System.out.println(result);

    }

}
