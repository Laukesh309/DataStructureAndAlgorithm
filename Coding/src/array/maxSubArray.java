package array;

public class maxSubArray {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMaxSubArray(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
            arr[i] = result;
        }
        printArray(arr);
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tempResult = 0;
            for (int j = i; j < arr.length; j++) {
                tempResult = i - 1 < 0 ? arr[j] : arr[j] - arr[i - 1];
                maxValue = Math.max(maxValue, tempResult);
            }

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(findMaxSubArray(arr));
    }

}
