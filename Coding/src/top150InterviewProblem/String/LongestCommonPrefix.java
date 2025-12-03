package top150InterviewProblem.String;

public class LongestCommonPrefix {

    public static String findLangestString(String str[]) {
        String result = str[0];
        for (int i = 1; i < str.length; i++) {
            String cur = str[i];
            int currentIndex = 0;
            String currResult = "";
            while (currentIndex < result.length() && currentIndex < cur.length()) {
                if (result.charAt(currentIndex) == cur.charAt(currentIndex)) {
                    currResult = currResult + result.charAt(currentIndex);
                    currentIndex++;
                } else {
                    break;
                }

            }
            result = currResult;
        }
        return result;

    }

    public static void main(String[] args) {
        String str[] = { "dog", "racecar", "car" };
        System.out.println(findLangestString(str));
    }

}
