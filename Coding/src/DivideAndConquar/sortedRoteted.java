package DivideAndConquar;

public class sortedRoteted {

    public static int findPivotIndex(int arr[], int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            return firstIndex;
        }
        int midIndex = (firstIndex + lastIndex) / 2;
        if (arr[midIndex] >= arr[0]) {
            return findPivotIndex(arr, midIndex + 1, lastIndex);
        } else {
            return findPivotIndex(arr, firstIndex, midIndex);
        }
    }

    public static int findTargetValueIndex(int arr[], int firstIndex, int lastIndex, int target) {
        System.out.println(firstIndex + " " + lastIndex);
        if (firstIndex > lastIndex) {
            return -1;
        }

        int midIndex = (firstIndex + lastIndex) / 2;
        if (arr[midIndex] == target) {
            return midIndex;
        }
        if (arr[midIndex] >= arr[0]) {
            if (arr[firstIndex] <= target && target < arr[midIndex]) {
                return findTargetValueIndex(arr, firstIndex, midIndex - 1, target);
            } else {
                return findTargetValueIndex(arr, midIndex + 1, lastIndex, target);
            }
        } else {
            if (arr[midIndex] < target && target <= arr[lastIndex]) {
                return findTargetValueIndex(arr, midIndex + 1, lastIndex, target);
            } else {
                return findTargetValueIndex(arr, firstIndex, midIndex - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        int arr[] = { 5, 1, 2 };
        int target = 5;
        System.out.println(findPivotIndex(arr, 0, arr.length - 1));
        System.out.println(findTargetValueIndex(arr, 0, arr.length - 1, target));
    }

}
