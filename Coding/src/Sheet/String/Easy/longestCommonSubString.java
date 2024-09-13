package Sheet.String.Easy;

public class longestCommonSubString {

    public static String langestCommonString(String str[]) {
        String result = String.join("", str);
        for (int i = 0; i < str.length; i++) {
            String str1 = str[i];
            int counter = 0;
            while (counter < result.length() && counter < str1.length()
                    && result.charAt(counter) == str1.charAt(counter)) {
                counter++;
            }
            if (counter == 0) {
                return "";
            }
            result = result.substring(0, counter);
        }
        return result;
    }

    public static String getLangestString(String str[]) {
        String result = "";

    }

    public static void main(String[] args) {
        String[] str = { "aaa", "aa", "aaa" };
        System.out.println(langestCommonString(str));

    }

}
