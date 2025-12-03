package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    public static void findCombination(String digit, String arr[], List<String> result, int currentDigitIndex,
            String currentResult) {
        if (currentDigitIndex >= digit.length()) {
            result.add(currentResult);
            return;
        }
        int curStringInt = digit.charAt(currentDigitIndex) - '0';
        String currString = arr[curStringInt];
        for (int i = 0; i < currString.length(); i++) {
            findCombination(digit, arr, result, currentDigitIndex + 1, currentResult + currString.charAt(i));
        }
        return;

    }

    public static void main(String[] args) {
        String digit = "23";
        String arr[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();
        findCombination(digit, arr, result, 0, "");
        System.out.println(result);
    }

}
