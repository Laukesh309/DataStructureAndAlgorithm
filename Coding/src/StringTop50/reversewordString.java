package StringTop50;

public class reversewordString {

    public static String reverseString(String str) {
        String str2[] = str.split(" ");
        String result = "";
        for (int i = 0; i < str2.length; i++) {
            if (!str2[i].equals(""))
                result = str2[i] + " " + result;
        }
        return result.trim();
    }

    public static void main(String[] args) {
        String str = "cb ipctpyru  bovcbo";
        System.out.println(str.length());
        System.out.println(reverseString(str).length());

    }

}
