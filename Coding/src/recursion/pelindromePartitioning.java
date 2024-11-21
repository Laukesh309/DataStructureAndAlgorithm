package recursion;

import java.util.ArrayList;
import java.util.List;

public class pelindromePartitioning {

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

    public static void allPelindromeSequece(String str, int currentInex, ArrayList<String> result,
            List<List<String>> finalResult) {
        if (currentInex >= str.length()) {

            finalResult.add(result);
            return;
        }
        for (int i = currentInex; i < str.length(); i++) {
            String currentSubString = str.substring(currentInex, i + 1);
            if (checkPelindrome(currentSubString)) {
                result.add(currentSubString);
                allPelindromeSequece(str, i + 1, new ArrayList<>(result), finalResult);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> finalResult = new ArrayList<>();
        allPelindromeSequece(str, 0, new ArrayList<>(), finalResult);
        System.out.println(finalResult);

    }

}
