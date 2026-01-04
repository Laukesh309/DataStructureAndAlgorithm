package ArrayRevision;

import Stack.pushBottom;

public class maxCircularSumArray {

    public static int findMaximumSum(int nums[]) {
        int currentMax = nums[0];
        int gMax = nums[0];
        int currentMin = nums[0];
        int gMin = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            gMax = Math.max(currentMax, gMax);
            currentMin = Math.min(currentMin + nums[i], nums[i]);
            gMin = Math.min(gMin, currentMin);
            total = total + nums[i];
        }
        if (total == gMin) {
            return gMax;
        }
        return Math.max(gMax, total - gMin);

    }

    public static void findMaxValue(int num[]) {
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int nums[] = { 1, -2, 3, -2 };
        findMaximumSum(nums);
    }

}
