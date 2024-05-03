package recursion.LoveBabbar;

public class permutationString {

    public static void findAllPermutation(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i + 1);
            findAllPermutation(newString, ans + currentChar);
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        findAllPermutation(str, "");
    }

}
