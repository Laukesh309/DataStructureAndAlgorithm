package BinarySearchRevision;

public class NthRoot {

    public static int getPower(int n, int result) {
        int finalResult = 1;
        for (int i = 0; i < n; i++) {
            finalResult = finalResult * result;
        }
        return finalResult;
    }

    public static int findRoot(int n, int m, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int value = getPower(n, mid);
        if (value == m) {
            return mid;
        }
        if (value > m) {
            return findRoot(n, m, start, mid - 1);
        } else {
            return findRoot(n, m, mid + 1, end);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int m = 16;
        System.out.println(findRoot(n, m, 1, m));
    }

}
