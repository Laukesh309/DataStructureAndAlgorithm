package recursion;

public class fibbonacciNumber {

    public static int findFibbonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return findFibbonacci(n - 1) + findFibbonacci(n - 2);
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(findFibbonacci(N));

    }

}
