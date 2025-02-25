package top150InterviewProblem.TwoPointer;

public class validPalindrome {

    public static boolean isValid(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                str2 += str.charAt(i);
            }
        }
        int start = 0;
        int end = str2.length() - 1;
        System.out.println(str2);
        while (start <= end) {
            if (str2.charAt(start) != str2.charAt(end)) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

    public static boolean findIsValid(String str) {
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

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // s = s.toLowerCase();
        // s = s.replaceAll("[^a-zA-Z0-9]", "");
        // System.out.println(findIsValid(s));
        System.out.println(isValid(s.toLowerCase()));

    }

}
