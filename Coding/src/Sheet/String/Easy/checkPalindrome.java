package Sheet.String.Easy;

public class checkPalindrome {

    public static boolean checkPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        int startPointer = 0;
        int endPointer = str.length() - 1;
        while (startPointer <= endPointer) {
            if (str.charAt(startPointer++) != str.charAt(endPointer--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(checkPalindrome(str));
    }

}
