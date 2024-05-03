package recursion.LoveBabbar;

public class powerValue {

    public static int powerValue(int n, int x) {
        if (x == 0) {
            return 1;
        }
        int totalValue = powerValue(n, x / 2);
        if (x % 2 == 0) {
            return totalValue * totalValue;
        } else {
            return n * totalValue * totalValue;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int x = 4;
        System.out.println(powerValue(n, x));
    }

}
