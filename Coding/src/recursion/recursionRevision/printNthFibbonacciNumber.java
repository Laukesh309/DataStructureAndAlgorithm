package recursion.recursionRevision;

public class printNthFibbonacciNumber {

    public static int findFibbonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return findFibbonacci(n - 1) + findFibbonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(findFibbonacci(n));
    }

}
