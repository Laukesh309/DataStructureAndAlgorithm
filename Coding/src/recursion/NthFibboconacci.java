package recursion;

public class NthFibboconacci {

    public static int findFibbonaci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return findFibbonaci(num - 1) + findFibbonaci(num - 2);
    }

    public static void main(String[] args) {
        int num = 9;
        int fibbonacciNumber = findFibbonaci(num);
        System.out.println(fibbonacciNumber);
    }

}
