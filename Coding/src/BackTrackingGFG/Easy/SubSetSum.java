package BackTrackingGFG.Easy;

public class SubSetSum {

    public static boolean findTotalSum(int arr[], int totalSum, int currentIndex) {
        if (totalSum == 0) {
            return true;
        }
        if (totalSum < 0 || currentIndex >= arr.length) {
            return false;
        }
        return findTotalSum(arr, totalSum - arr[currentIndex], currentIndex + 1)
                || findTotalSum(arr, totalSum, currentIndex + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 30;
        System.out.println(findTotalSum(arr, sum, 0));
    }

}
