package top150InterviewProblem.slidingWindow;

public class minimumSizeSubArray {

    public static int findMinimumSizeSubArray(int arr[], int target) {
        int firstPointer = 0;
        int secondPointer = 0;
        int result = Integer.MAX_VALUE;
        int subSetSum = 0;
        while (secondPointer < arr.length) {
            subSetSum += arr[secondPointer];
            if (subSetSum >= target) {
                while (firstPointer <= secondPointer && subSetSum >= target) {
                    result = Math.min(result, secondPointer - firstPointer + 1);
                    subSetSum -= arr[firstPointer];
                    firstPointer++;

                }
            }
            secondPointer++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(findMinimumSizeSubArray(arr, target));
    }

}
