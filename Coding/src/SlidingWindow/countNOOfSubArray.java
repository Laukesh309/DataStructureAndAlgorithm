package SlidingWindow;

public class countNOOfSubArray {

    public static int findTotalCount(int nums[], int k) {
        int left = 0;
        int right = 0;
        int totalCount = 0;
        int sum = 0;
        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                totalCount++;
            }
            while (totalCount > k) {
                if (nums[left] % 2 != 0) {
                    totalCount--;
                }
                left++;
            }
            sum = sum + right - left + 1;
            right++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 1, 1 };
        int k = 3;
        int total = findTotalCount(nums, k) - findTotalCount(nums, k - 1);
        System.out.println(total);

    }

}
