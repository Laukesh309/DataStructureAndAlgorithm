package recursion;

public class printSumNNumber {

    public static int bottomToTopApproach(int N) {
        if (N == 0) {
            return 0;
        }
        return bottomToTopApproach(N - 1) + N;
    }

    public static int topDownApproach(int N, int sum) {
        if (N == 0) {
            return sum;
        }
        return topDownApproach(N - 1, sum + N);
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(topDownApproach(N, 0));
        System.out.println(bottomToTopApproach(N));
    }

}
