package BitManipulation;

public class reverseBit {

    public static String convertBinaryString(int n) {
        String result = "";
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                result = 1 + result;
            } else {
                result = 0 + result;
            }
        }
        return result;
    }

    public static int reverseBit(String temp) {
        int power = 1;
        int result = 0;

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                result += power;
            }
            power = power * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 43261596;
        String temp = convertBinaryString(n);
        System.out.println(temp);
        System.out.println(reverseBit(temp));

    }

}
