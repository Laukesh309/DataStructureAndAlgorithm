package Sheet.Array.medium;

// https://leetcode.com/problems/trapping-rain-water/solutions/5126477/video-keep-max-height-on-the-both-side/
public class tappingRainWater {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMaxTapWater(int arr[]) {

        int preffixMaxArr[] = new int[arr.length];
        int suffixMaxArr[] = new int[arr.length];
        int preffixMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (preffixMax <= arr[i]) {
                preffixMax = arr[i];
            }
            preffixMaxArr[i] = preffixMax;
        }
        int suffixMax = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (suffixMax <= arr[i]) {
                suffixMax = arr[i];
            }
            suffixMaxArr[i] = suffixMax;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int minValue = Math.min(preffixMaxArr[i], suffixMaxArr[i]);
            int water = minValue - arr[i];
            if (water > 0) {
                result = result + water;
            }
        }
        return result;
    }

    public static int findmaxWaterOptimised(int arr[]) {
        int result[] = new int[arr.length];
        int prefixMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (prefixMax <= arr[i]) {
                prefixMax = arr[i];
            }
            result[i] = prefixMax;
        }
        printArray(result);
        int suffixMax = 0;
        int maxWaterResult = 0;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (suffixMax <= arr[j]) {
                suffixMax = arr[j];
            }
            int minValue = Math.min(suffixMax, result[j]) - arr[j];
            if (minValue > 0) {
                maxWaterResult += minValue;
            }

        }
        return maxWaterResult;
    }
    // public int trap(int[] height) {
    // int leftMax[] = new int[height.length];
    // int rightMax[] = new int[height.length];
    // leftMax[0] = height[0];
    // for (int i = 1; i < height.length; i++) {
    // leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    // }
    // rightMax[height.length - 1] = height[height.length - 1];
    // for (int j = height.length - 2; j >= 0; j--) {
    // rightMax[j] = Math.max(rightMax[j + 1], height[j]);
    // }
    // int totalWaterTrapping = 0;
    // for (int i = 0; i < height.length; i++) {
    // int minHeight = Math.min(leftMax[i], rightMax[i]);
    // int value = minHeight - height[i];
    // if (value > 0) {
    // totalWaterTrapping += value;
    // }
    // }
    // return totalWaterTrapping;

    // }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(findmaxWaterOptimised(arr));
    }

}
