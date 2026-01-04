package BinarySearchRevision;

public class peakElemement {

    public static int findPeakElement(int nums[], int startIndex, int endIndex) {
        if (startIndex > nums.length - 1) {
            return endIndex;
        }
        if (endIndex < 0) {
            return startIndex;
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (midIndex == 0 || midIndex == nums.length - 1) {
            if (midIndex == 0) {
                return nums[0] > nums[1] ? nums[0] : nums[1];
            } else {
                return nums[midIndex];
            }
        }
        if (nums[midIndex] > nums[midIndex - 1] && nums[midIndex] > nums[midIndex + 1]) {
            return midIndex;
        }
        if (nums[midIndex] > nums[midIndex - 1]) {
            return findPeakElement(nums, midIndex + 1, endIndex);
        } else {
            return findPeakElement(nums, startIndex, midIndex - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums, 0, nums.length - 1));

    }

}
