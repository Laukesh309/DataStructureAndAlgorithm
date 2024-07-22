package DynamicProgramming;

public class minDifference {

    public static int findSumOFArray(int arr[], int inititalValue, int lastValue) {
        int result = 0;
        for (int i = inititalValue; i <= lastValue; i++) {
            result += arr[i];
        }
        return result;
    }

    public static int findMinDifference(int arr[], int currentIndex) {
        if (currentIndex >= arr.length) {
            return Integer.MAX_VALUE;
        }

        int totalResult = Integer.MAX_VALUE;
        for (int i = currentIndex; i < arr.length; i++) {
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[i];
            arr[i] = temp;
            int setFirstResult = findSumOFArray(arr, 0, currentIndex);
            int setSecondResult = findSumOFArray(arr, currentIndex + 1, arr.length - 1);
            int result = Math.abs(setFirstResult - setSecondResult);
            int minValue = Math.min(result, findMinDifference(arr, currentIndex + 1));
            arr[i] = arr[currentIndex];
            arr[currentIndex] = temp;
            System.out.println(setFirstResult + " " + setSecondResult + " " + minValue);
            totalResult = Math.min(totalResult, minValue);
        }

        return totalResult;
    }

    public static int findMinDifferenceSubsetMethod(int arr[], int currentIndex, int targetSum, int result) {
        if (currentIndex >= arr.length || targetSum <= 0) {
            return result;
        }
        if (arr[currentIndex] <= targetSum) {
            return Math.max(
                    findMinDifferenceSubsetMethod(arr, currentIndex + 1, targetSum - arr[currentIndex],
                            result + arr[currentIndex]),
                    findMinDifferenceSubsetMethod(arr, currentIndex + 1, targetSum, result));
        } else {
            return findMinDifferenceSubsetMethod(arr, currentIndex + 1, targetSum, result);
        }
    }

    public static int findMinByRange(int arr[], int currentIndex, int targetSum, int result) {
        if (currentIndex >= arr.length) {

            int difference = Math.abs(targetSum - 2 * result);
            return difference;

        }
        int includeSubsetValue = findMinByRange(arr, currentIndex + 1, targetSum, result + arr[currentIndex]);
        int excludeSubSetValue = findMinByRange(arr, currentIndex + 1, targetSum, result);
        return Math.min(includeSubsetValue, excludeSubSetValue);
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 6, 11, 5 };
        int arr[] = { 1, 2, 7 };
        int targetSum = findSumOFArray(arr, 0, arr.length - 1);
        // System.out.println(targetSum);
        // System.out.println(findMinDifference(arr, 0));
        // int maxValue = findMinDifferenceSubsetMethod(arr, 0, targetSum / 2, 0);
        // System.out.println(maxValue);
        // System.out.println(targetSum - maxValue * 2);

        System.out.println(findMinByRange(arr, 0, targetSum, 0));

    }

}
