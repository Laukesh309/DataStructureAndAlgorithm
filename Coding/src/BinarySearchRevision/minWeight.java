package BinarySearchRevision;

public class minWeight {

    public static int findTotalDay(int arr[], int result) {
        int maxSum = arr[0];
        int totalCount = 1;
        for (int i = 1; i < arr.length; i++) {
            maxSum = maxSum + arr[i];
            if (maxSum > result) {
                totalCount++;
                maxSum = arr[i];
            }
        }
        return totalCount;
    }

    public static void findMaxDay(int arr[], int d, int start, int end, int finalResut[]) {
        if (start > end) {
            return;
        }

        int result = (start + end) / 2;

        if (findTotalDay(arr, result) > d) {
            findMaxDay(arr, d, result + 1, end, finalResut);
        } else {
            finalResut[0] = Math.min(finalResut[0], result);
            findMaxDay(arr, d, start, result - 1, finalResut);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 9, 8, 10 };
        int d = 3;
        int finalResult[] = { Integer.MAX_VALUE };
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = Math.max(start, arr[i]);
            end = end + arr[i];
        }
        findMaxDay(arr, d, start, end, finalResult);
        System.out.println(finalResult[0]);
    }
}
