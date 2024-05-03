package recursion.LoveBabbar;

public class fibbonacci {

    public static int fibbonacciNumber(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibbonacciNumber(n - 1) + fibbonacciNumber(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        int totalSum = fibbonacciNumber(n);
        System.out.println(totalSum);

    }

}
