package GFGDynamicProgrammin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class palindromeAllQuestion {

    public static boolean checkStringPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    public static void findAllPalidrome(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (checkStringPalindrome(s, i, j)) {
                    result.add(s.substring(i, j + 1));
                }
            }
        }
        System.out.println(result);
    }

    ///
    ///
    public static void getPalindrome(String s, int leftCenter, int rightCenter, ArrayList<String> result) {
        while (leftCenter >= 0 && rightCenter < s.length() && s.charAt(leftCenter) == s.charAt(rightCenter)) {
            result.add(s.substring(leftCenter, rightCenter + 1));
            leftCenter--;
            rightCenter++;
        }
    }

    public static void findAllPalindromeCenter(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int center = 0; center < s.length(); center++) {
            getPalindrome(s, center, center, result);
            getPalindrome(s, center, center + 1, result);
        }
        System.out.println(result);
    }

    public static void findAllPalidromeDynamic(String s) {
        Set<String> result = new HashSet<>();
        boolean isPalidrome[][] = new boolean[s.length()][s.length()];
        for (int row = s.length() - 1; row >= 0; row--) {
            for (int col = row; col < s.length(); col++) {
                if (s.charAt(row) == s.charAt(col)) {
                    if (col - row <= 2) {
                        isPalidrome[row][col] = true;
                    } else {
                        isPalidrome[row][col] = isPalidrome[row + 1][col - 1];
                    }
                    if (isPalidrome[row][col]) {
                        result.add(s.substring(row, col + 1));
                    }

                }
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(checkStringPalindrome(s, 0, s.length() - 1));
        findAllPalidrome(s);
        findAllPalindromeCenter(s);
        findAllPalidromeDynamic(s);

    }

}
