package Sheet.String.Easy;

public class removeConsecutiveChar {

    public static String removeCharacter(String str) {
        String result = "" + str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                result += str.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "aabaa";
        System.out.println(removeCharacter(str));
    }

}
