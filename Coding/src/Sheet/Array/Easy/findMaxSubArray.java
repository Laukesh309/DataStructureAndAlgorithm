package Sheet.Array.Easy;

public class findMaxSubArray {

    public static int findSubArrayMaxSum(int arr[]) {
        int result = Integer.MIN_VALUE;
        int currentValue = 0;
        for (int i = 0; i < arr.length; i++) {
            currentValue += arr[i];
            result = Math.max(result, currentValue);
            if (currentValue < 0) {
                currentValue = 0;
            }
        }
        return result;
    }

    // previous solution
    public int maxSubArray(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax = currentMax + arr[i];
            if (currentMax > maxValue) {
                maxValue = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(findSubArrayMaxSum(arr));

    }

}
