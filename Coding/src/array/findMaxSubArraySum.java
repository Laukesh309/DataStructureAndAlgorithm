package array;

public class findMaxSubArraySum {

    public static int findMaxSum(int arr[], int currentIndex) {
        if (currentIndex >= arr.length) {
            return Integer.MIN_VALUE;
        }
        int result = arr[currentIndex];
        int MaxElement = Integer.MIN_VALUE;
        for (int i = currentIndex + 1; i < arr.length; i++) {
            result += arr[i];
            MaxElement = Math.max(MaxElement, result);
        }

        int subArrayResult = findMaxSum(arr, currentIndex + 1);
        return Math.max(result, subArrayResult);

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMaxValueByPrefixSum(int arr[]) {
        int resultArr[] = new int[arr.length];
        resultArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            resultArr[i] = resultArr[i - 1] + arr[i];
        }
        // printArray(resultArr);
        int maxValue = Integer.MIN_VALUE;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                // if (i - 1 < 0) {
                // MaxValue = Math.max(MaxValue, resultArr[j]);
                // } else {
                // MaxValue = Math.max(MaxValue, resultArr[j] - resultArr[i - 1]);
                // }
                int sum = start == 0 ? resultArr[end] : resultArr[end] - resultArr[start - 1];
                maxValue = Math.max(maxValue, sum);
            }

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int arr[] = { 1, -2, 6, -1, 3 };
        // int arr[] = { 2, 4, 6, 8, 10 };
        System.out.println(findMaxSum(arr, 0));
        System.out.println(findMaxValueByPrefixSum(arr));
    }

}
