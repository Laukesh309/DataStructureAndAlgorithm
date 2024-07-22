package array;

public class trappingRainWater {

    public static void findMaximumWater(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int totalWaterTrapping = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            int value = minHeight - height[i];
            if (value > 0) {
                totalWaterTrapping += value;
            }
        }
        System.out.println(totalWaterTrapping);

    }

    public static void main(String[] args) {
        // int arr[] = { 4, 2, 0, 3, 2, 5 };
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        findMaximumWater(arr);

    }

}
