package array;

public class findKthSmallest {

    public static int getMin(int arr[]) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
        }
        return minValue;
    }

    public static int getMax(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        return maxValue;
    }

    public static int countValue(int arr[], int min, int max) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static int findLargetValue(int arr[], int min, int mid, int k) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= mid) {
                maxValue = Math.max(maxValue, arr[i]);
            }

        }
        return maxValue;
    }

    public static int findKthSmallestMin(int arr[], int min, int max, int k) {
        int mid = (max + min) / 2;
        int count = countValue(arr, min, mid);
        if (count == k) {
            return findLargetValue(arr, min, mid, k);
        }
        if (count > k) {
            return findKthSmallestMin(arr, min, mid, k);
        }
        if (count < k) {
            return findKthSmallestMin(arr, mid, max, k - count);
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        int min = getMin(arr);
        int max = getMax(arr);
        System.out.println(findKthSmallestMin(arr, min, max, k));
    }

}
