package BackTrackingTop20;

public class subSetProblemBoolean {

    public static boolean findPath(int arr[], int curIndex, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || curIndex >= arr.length) {
            return false;
        }
        return findPath(arr, curIndex + 1, sum - arr[curIndex]) || findPath(arr, curIndex + 1, sum);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(findPath(arr, 0, sum));

    }

}
