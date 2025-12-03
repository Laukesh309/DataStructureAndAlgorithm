package StringTop50;

public class reverseString {

    public static String reverseString(String str) {
        int initial = 0;
        int last = str.length() - 1;
        StringBuilder sb = new StringBuilder(str);
        while (initial < last) {
            sb.setCharAt(last, str.charAt(initial));
            sb.setCharAt(initial, str.charAt(last));
            last--;
            initial++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Geeks";
        System.out.println(reverseString(str));
    }
}
