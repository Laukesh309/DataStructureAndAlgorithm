package DynamicProgramming;

public class equalSumPartition {
    public static int calculateTotalSum(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static int isConvertedEqualSum(int arr[], int currentIndex, int targetSum, int result) {
        if (currentIndex >= arr.length) {
            if (targetSum == 2 * result) {
                return 1;
            }
            return 0;
        }
        return isConvertedEqualSum(arr, currentIndex + 1, targetSum, result + arr[currentIndex])
                + isConvertedEqualSum(arr, currentIndex + 1, targetSum, result);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 11, 5 };
        int targetSum = calculateTotalSum(arr);
        System.out.println(isConvertedEqualSum(arr, 0, targetSum, 0));
    }

}
