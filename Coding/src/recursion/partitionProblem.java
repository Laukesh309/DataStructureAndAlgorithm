package recursion;

import java.util.ArrayList;
import java.util.List;

public class partitionProblem {

    public static boolean checkPelindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void printSubString(String str, int currentIndex, ArrayList<String> currentResult,
            List<List<String>> finalResult) {
        if (currentIndex >= str.length()) {
            finalResult.add(currentResult);
            return;
        }
        String tempString = "";
        for (int i = currentIndex; i < str.length(); i++) {
            tempString += str.charAt(i);
            if (checkPelindrome(tempString)) {
                currentResult.add(tempString);
                printSubString(str, i + 1, new ArrayList<>(currentResult), finalResult);
                currentResult.remove(currentResult.size() - 1);

            } else {
                continue;
            }

        }
    }

    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> finalResult = new ArrayList<>();
        printSubString(str, 0, new ArrayList<String>(), finalResult);
        System.out.println(finalResult);
    }

}
