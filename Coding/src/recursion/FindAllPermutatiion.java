package recursion;

public class FindAllPermutatiion {

    public static void findAllPermutationString(String str, String ans) {
        if (str.isEmpty()) {
            counter++;
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            findAllPermutationString(str.substring(0, i) + str.substring(i + 1), ans + str.charAt(i));
        }
    }

    public static int counter = 0;

    public static void main(String[] args) {
        String str = "abc";

        findAllPermutationString(str, "");
        System.out.println("totalNoOfPermutation-->" + counter);
    }
}
