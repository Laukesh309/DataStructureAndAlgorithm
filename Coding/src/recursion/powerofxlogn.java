package recursion;

public class powerofxlogn {

    public static int findPower(int x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return findPower(x, n / 2) * findPower(x, n / 2);
        } else {
            return x * findPower(x, (n - 1) / 2) * findPower(x, (n - 1) / 2);
        }

    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        int totalPowerValue = findPower(x, n);
        System.out.println(totalPowerValue);
    }

}
