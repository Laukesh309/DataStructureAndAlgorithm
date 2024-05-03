package Backtracking;

public class FindAllPermutation {

    public static void findAllPermuttationString(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            System.out.println();
            return;
        }
        // for (int i = 0; i < str.length(); i++) {
        // char cb = str.charAt(i);
        // String newString = ans + cb;
        // str.deleteCharAt(i);
        // findAllPermuttationString(str, newString);
        // str.insert(i, cb);
        // }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i + 1);
            System.out.println(ans + "     " + str);
            findAllPermuttationString(newString, ans + curr);

        }

    }

    public static void main(String[] args) {
        String str = new String("abc");
        findAllPermuttationString(str, "");
    }

}
