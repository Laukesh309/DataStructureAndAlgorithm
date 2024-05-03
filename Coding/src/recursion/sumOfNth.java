package recursion;

public class sumOfNth {
    public static int sumOfNaturalNumber(int num) {
        if (num == 0) {
            return 0;
        }
        return num + sumOfNaturalNumber(num - 1);
    }

    public static void main(String[] args) {
        int num = 9;
        int totalSum = sumOfNaturalNumber(num);
        System.out.println(totalSum);
    }

}
