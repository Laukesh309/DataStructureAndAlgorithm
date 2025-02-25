package BackTrackingRevision;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    public static void findAllString(String mapping[], String digit, int currentIndex, String result,
            List<String> finalResult) {
        if (currentIndex > digit.length() - 1) {
            finalResult.add(result);
            return;
        }
        int currentValue = digit.charAt(currentIndex) - '0';
        String tempString = mapping[currentValue];
        for (int i = 0; i < tempString.length(); i++) {
            findAllString(mapping, digit, currentIndex + 1, result + tempString.charAt(i), finalResult);
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        String mapping[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> finalResult = new ArrayList<>();
        findAllString(mapping, digits, 0, "", finalResult);

    }

}
