package kedaneAlgo;

public class kedaneAlgo {

    public static int findLargestSum(int nums[]) {

        int max = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(currentMax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 4, -1, 7, 8 };
        System.out.println(findLargestSum(nums));

    }

}
