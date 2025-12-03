package SlidingWindow;

public class maxConsecutiveOne {

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, k = 2;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < nums.length && left < nums.length) {
            if (nums[right] == 0) {
                if (k > 0) {
                    max = Math.max(max, right - left + 1);
                    right++;
                    k--;

                } else if (nums[left] == 0) {
                    k++;
                    left++;
                } else {
                    left++;
                }

            } else {
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        System.out.println(max);
    }

}
