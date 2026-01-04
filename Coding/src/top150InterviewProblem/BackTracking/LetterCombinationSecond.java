package top150InterviewProblem.BackTracking;

import java.util.List;

import java.util.ArrayList;;;

public class LetterCombinationSecond {

    public static void findResult(String mapping[], String digits, int currentIndex, String tempResult,
            List<String> result) {
        System.out.println(currentIndex);
        if (currentIndex >= digits.length()) {
            String finalResult = new String(tempResult);
            result.add(finalResult);
            return;
        }
        int index = digits.charAt(currentIndex) - '0';
        String str = mapping[index];
        for (int i = 0; i < str.length(); i++) {
            findResult(mapping, digits, currentIndex + 1, tempResult + mapping[index].charAt(i), result);
        }
        return;
    }

    public static void main(String[] args) {
        String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String digits = "23";
        List<String> result = new ArrayList<>();
        findResult(mapping, digits, 0, "", result);
        System.out.println(result);

    }

}
