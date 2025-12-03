package StringTop50;

public class pelindromicCheck {

    public static boolean checkPelindrome(String str) {
        int initial = 0;
        int last = str.length() - 1;
        while (initial <= last) {
            if (str.charAt(initial) != str.charAt(last)) {
                return false;
            }
            initial++;
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(checkPelindrome(str));

    }

}
