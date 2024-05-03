package recursion.LoveBabbar;

public class stairClimb {

    public static int stairClimbFunc(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return stairClimbFunc(n - 1) + stairClimbFunc(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(stairClimbFunc(n));
    }

}
