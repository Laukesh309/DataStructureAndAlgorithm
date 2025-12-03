package BitManipulation;

public class DecimaltoBinary {

    public static String findBinary(int num) {
        String result = "";

        while (num != 0) {
            result = num % 2 + result;
            num = num / 2;
        }
        return result;
    }

    public static void ConvertToDecimal(String num) {
        int p2 = 1;
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(num.length() - i - 1) == '1') {
                result += p2;
            }

            p2 = p2 * 2;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int num = 41;
        String result = findBinary(num);
        System.out.println(result);
        ConvertToDecimal(result);
    }

}
