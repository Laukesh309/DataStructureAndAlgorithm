package Sheet.Array.medium;

public class maximumProductSubArray {

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static int findMaxSubArray(int arr[]) {

        int maxiMumValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxiMumValue = Math.max(maxiMumValue, arr[i]);
            int currentValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                currentValue *= arr[j];
                maxiMumValue = Math.max(maxiMumValue, currentValue);

            }
        }
        return maxiMumValue;

    }

    public static void main(String[] args) {
        int arr[] = { -2, 0, -1 };
        System.out.println(findMaxSubArray(arr));

    }

}
