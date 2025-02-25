package top150InterviewProblem.BinarySearch;

public class sqrt {

    public static int findSqrt(int n, int firstIndex, int lastIndex, int target) {
        int mid = (firstIndex + lastIndex) / 2;
        int product = mid * mid;
        if (product == target) {
            return mid;
        }
        if (firstIndex > lastIndex) {
            return lastIndex;
        }
        if (product > target) {
            return findSqrt(n, firstIndex, mid - 1, target);
        }
        return findSqrt(n, firstIndex + 1, lastIndex, target);

    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(findSqrt(n, 0, n, n));

    }

}
