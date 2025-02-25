package top150InterviewProblem.DPProblem.medium;

public class powxandn {

    public static double findSquare(double x, long n) {
        System.out.println(n);
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / findSquare(x, Math.abs(n));
        }
        double square = 1;
        if (n % 2 == 0) {
            square = findSquare(x, n / 2);
            square = square * square;
        } else {
            square = findSquare(x, (n - 1) / 2);
            square = x * square * square;
        }
        return square;

    }

    public static void main(String[] args) {
        double x = 1.00000;
        int n = -2147483648;
        System.out.println(findSquare(x, n));
    }

}
