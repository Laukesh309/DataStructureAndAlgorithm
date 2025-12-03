package ArrayRevision;

public class maxCircular {

    public static int findTotalElement(int nums[], int startIndex) {
        int curMax = nums[startIndex];
        int gMax = nums[startIndex];
        int nextIndex = (startIndex + 1) % nums.length;
        while (nextIndex != startIndex) {
            curMax = Math.max(curMax + nums[nextIndex], nums[nextIndex]);
            gMax = Math.max(curMax, gMax);
            nextIndex = (nextIndex + 1) % nums.length;

        }
        return gMax;

    }

    public static int findMinSum(int nums[]) {
        int maxSum = nums[0];
        int gMax = nums[0];
        int minSum = nums[0];
        int gMinSum = nums[0];
        int totalSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            gMax = Math.max(maxSum, gMax);
            minSum = Math.min(minSum + nums[i], nums[i]);
            gMinSum = Math.min(gMinSum, minSum);
            totalSum = totalSum + nums[i];
        }
        System.out.println(totalSum + " " + gMinSum + " " + gMax);
        if (totalSum == gMinSum) {
            return gMax;
        }
        return Math.max(gMax, totalSum - gMinSum);

    }

    public static void main(String[] args) {
        int nums[] = { 5, -3, 5 };
        // int globalMax = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // globalMax = Math.max(globalMax, findTotalElement(nums, i));
        // }
        System.out.println(findMinSum(nums));
    }

}
