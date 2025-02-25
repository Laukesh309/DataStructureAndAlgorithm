package top150InterviewProblem.slidingWindowRevision;

public class minSizeSubSrray {

    public static int findMinSize(int arr[], int target) {
        int initialPointer = 0;
        int secondPointer = 0;
        int minSize = Integer.MAX_VALUE;
        int result = 0;
        while (initialPointer <= secondPointer && secondPointer < arr.length) {
            System.out.println(initialPointer + " " + secondPointer);
            if (result + arr[secondPointer] == target) {
                minSize = Math.min(minSize, secondPointer - initialPointer + 1);
                result += arr[secondPointer++];
                result -= arr[initialPointer++];
            } else if (result + arr[secondPointer] < target) {
                result += arr[secondPointer++];
            } else {
                result -= arr[initialPointer++];
            }

        }
        return minSize;
    }

    public static int findMinSizeSecond(int arr[], int target) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= arr[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(findMinSize(arr, target));
        System.out.println(findMinSizeSecond(arr, target));
    }

}
