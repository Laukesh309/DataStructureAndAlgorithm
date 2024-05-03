package recursion;

public class printPower {

    public static int findPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int power = x * findPower(x, n - 1);
        System.out.println(power);
        return power;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 6;
        int powerValue = findPower(x, n);
        System.out.println(powerValue);
    }

}
