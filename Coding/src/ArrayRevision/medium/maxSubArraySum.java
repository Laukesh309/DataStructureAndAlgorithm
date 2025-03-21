package ArrayRevision.medium;

public class maxSubArraySum {

    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + nums[i];
            result = Math.max(count, result);
            if (count < 0) {
                count = 0;
            }
        }
        System.out.println(result);
    }

}
