package recursion.LoveBabbar;

public class subsequence {

    public static void findSubSequece(String str, String ans) {

        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String nextString = str.substring(0, i) + str.substring(i + 1);
            findSubSequece(nextString, ans + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "abcda";
        findSubSequece(str, "");

    }

}
