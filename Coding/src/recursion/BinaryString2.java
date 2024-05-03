package recursion;

public class BinaryString2 {

    public static void binaryString(int n, int lastPlace, StringBuilder str) {
        if (n == 0) {

            System.out.println(str);
            return;
        }
        binaryString(n - 1, 0, str.append("0"));
        str.deleteCharAt(str.length() - 1);
        if (lastPlace == 0) {
            binaryString(n - 1, 1, str.append("1"));
            str.deleteCharAt(str.length() - 1);
            return;
        }

    }

    public static void main(String[] args) {

        int n = 3;
        binaryString(n, 0, new StringBuilder(""));

    }

}
