package Backtracking;

public class findAllPermutationR1 {

    public static void findAllPermutation(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String newString = str.substring(0, i) + str.substring(i + 1);
            findAllPermutation(newString, result + ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findAllPermutation(str, "");
    }

}
