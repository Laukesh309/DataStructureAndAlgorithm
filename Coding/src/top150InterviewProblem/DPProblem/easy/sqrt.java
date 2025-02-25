package top150InterviewProblem.DPProblem.easy;

public class sqrt {

    public static int findSqrt(int low, int high, int target) {
        if (low > high) {
            return high;
        }
        int mid = (low + high) / 2;
        if (mid * mid == target) {
            return mid;
        }
        if (mid * mid > target) {
            return findSqrt(low, mid - 1, target);
        } else {
            return findSqrt(mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        int x = 150;
        System.out.println(findSqrt(1, x, x));
    }

}
