package BitManipulation;

public class noOf1Bit {

    public static int findNoOfBit(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(findNoOfBit(n));

    }

}
