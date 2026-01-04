package TwoPointer;

public class pairSumRotated {

    public static int findPeakIndex(int arr[], int start, int end) {
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return i;
    }

    public static boolean findElement(int arr[], int target) {
        int lastIndex = findPeakIndex(arr, 0, arr.length - 1);
        int startIndex = (lastIndex + 1) % arr.length;
        while (startIndex != lastIndex) {
            int totalSum = arr[startIndex] + arr[lastIndex];
            if (totalSum == target) {
                return true;
            } else if (totalSum > target) {
                lastIndex = (lastIndex - 1 + arr.length) % arr.length;
            } else {
                startIndex = (startIndex + 1) % arr.length;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 3, 3, 3, 3 }, target = 3;
        System.out.println(findElement(arr, target));

    }

}
