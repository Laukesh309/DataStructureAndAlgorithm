package recursion.LoveBabbar;

import java.util.ArrayList;

public class findPhoneNumberSeries {

    public static ArrayList<String> findAllCombination(String str[], String phoneNumber, int currentIndex, String ans,
            ArrayList<String> mainAnswer) {
        if (currentIndex >= phoneNumber.length()) {
            System.out.println(ans);
            mainAnswer.add(ans);
            return mainAnswer;
        }
        int currentStringIndex = phoneNumber.charAt(currentIndex) - '0';
        String currentString = str[currentStringIndex];
        for (int j = 0; j < currentString.length(); j++) {
            findAllCombination(str, phoneNumber, currentIndex + 1, ans + currentString.charAt(j), mainAnswer);
        }
        return mainAnswer;
    }

    public static int counter = 0;

    public static void main(String[] args) {
        String str[] = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String phoneNumber = "23";
        findAllCombination(str, phoneNumber, 0, "", new ArrayList<String>());
        System.out.println(counter);

    }
}
