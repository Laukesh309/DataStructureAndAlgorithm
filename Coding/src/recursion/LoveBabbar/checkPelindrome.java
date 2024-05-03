package recursion.LoveBabbar;

public class checkPelindrome {

    public static boolean checkPelindromValue(String str, int startIndex, int lastIndex) {
        if (startIndex > lastIndex) {
            return true;
        }
        if (str.charAt(startIndex) != str.charAt(lastIndex)) {
            return false;
        }
        return checkPelindromValue(str, startIndex + 1, lastIndex - 1);
    }

    public static void main(String[] args) {
        String str = "abbcbba";
        boolean isPelindrome = checkPelindromValue(str, 0, str.length() - 1);
        System.out.println(isPelindrome);
    }

}
