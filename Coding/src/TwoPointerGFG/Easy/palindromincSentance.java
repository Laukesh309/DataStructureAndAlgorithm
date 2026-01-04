package TwoPointerGFG.Easy;

public class palindromincSentance {

    public static void main(String[] args) {

        String s = "Too hot to hoot";
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left <= right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right && Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
    }

}
