package recursion.LoveBabbar;

public class reverseString {

    public static String swap(String str, int firstIndex, int lastIndex) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(firstIndex, str.charAt(lastIndex));
        sb.setCharAt(lastIndex, str.charAt(firstIndex));
        return sb.toString();
    }

    public static String reveString(String str, int startIndex, int lastIndex) {
        if (startIndex > lastIndex) {
            return str;
        }
        str = swap(str, startIndex, lastIndex);
        startIndex++;
        lastIndex--;
        return reveString(str, startIndex, lastIndex);

    }

    public static void main(String[] args) {
        String str = "laukesh";
        System.out.println(reveString(str, 0, str.length() - 1));
    }

}
