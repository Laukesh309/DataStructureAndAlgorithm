package BitManipulations;

public class convetDecimalToBinary {

    public static void convertDecimalToBinary(int n) {
        String result = "";
        while (n != 0) {
            result = n % 2 + result;
            n = n / 2;
        }
        System.out.println(result);
    }

    public static void convertBinaryToDecimal(String str) {
        int result = 0;
        int base = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int currentNo = str.charAt(i) - '0';
            result = result + base * currentNo;
            base = base * 2;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        convertDecimalToBinary(5);
        convertBinaryToDecimal("1010");

    }

}
