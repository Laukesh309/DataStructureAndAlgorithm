package recursion.recursionRevision;

public class frindProblem {

    public static int findTotalPair(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int single = findTotalPair(n - 1);
        int pair = findTotalPair(n - 2) * n - 1;
        return single + pair;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(findTotalPair(n));
    }

}
