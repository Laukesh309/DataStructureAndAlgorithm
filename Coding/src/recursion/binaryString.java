package recursion;

public class binaryString {

    public static void BinaryString(int n, StringBuilder str, int lastIndex) {
        if (str.length() == n) {
            System.out.println(str);
            return;
        }
        if (str.charAt(lastIndex) == '1') {
            str.append("0");
            BinaryString(n, str, lastIndex + 1);
            return;
        }
        BinaryString(n, str.append("0"), lastIndex + 1);
        str.deleteCharAt(lastIndex + 1);
        BinaryString(n, str.append("1"), lastIndex + 1);
        str.deleteCharAt(lastIndex + 1);
        return;

    }

    public static void main(String[] args) {
        int n = 3;
        BinaryString(n, new StringBuilder("0"), 0);
        BinaryString(n, new StringBuilder("1"), 0);
        return;

    }

}
