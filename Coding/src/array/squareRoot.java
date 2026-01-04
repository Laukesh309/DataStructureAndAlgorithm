package array;

public class squareRoot {

    public static int findSquareRoot(int n, int start, int end) {
        if (start > end) {
            return start;
        }
        int mid = (start + end) / 2;
        int total = mid * mid;
        if (total == n) {
            return mid;
        }
        if (total > n) {
            return findSquareRoot(n, start, mid - 1);
        } else {
            return findSquareRoot(n, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(100, 1, 100));
    }

}
