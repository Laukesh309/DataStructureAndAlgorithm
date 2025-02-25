package top150InterviewProblem.slidingWindowRevision;

public class countTotalNoOfNiceArray {

    public static int findTotalNumber(int nums[], int k) {

        int left = 0;
        int right = 0;
        int addNumber = 0;
        int total = 0;
        while (right < nums.length) {
            if (nums[right] % 2 != 0) {
                addNumber++;
            }
            while (addNumber > k) {
                if (nums[left] % 2 != 0) {
                    addNumber--;
                }
                left++;
            }

            total += right - left + 1;
            right++;

        }
        return total;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 1, 1 };
        int k = 3;
        int target = findTotalNumber(nums, k);
        System.out.println(target);
        int lessTarget = findTotalNumber(nums, k - 1);
        System.out.println(lessTarget);
        System.out.println(target - lessTarget);

    }

}
