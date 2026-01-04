package BinarySearchRevision;

public class sortedRotated {

    public static int findIndex(int nums[], int startIndex, int endIndex, int target) {
        System.out.println(startIndex + " " + endIndex);
        if (startIndex > endIndex) {
            return -1;
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        }
        if (nums[midIndex] > nums[0]) {
            if (target > nums[startIndex] && target < nums[midIndex]) {
                return findIndex(nums, startIndex, midIndex - 1, target);
            } else {
                return findIndex(nums, midIndex + 1, endIndex, target);
            }

        } else {
            if (target > nums[midIndex] && target < nums[endIndex]) {
                return findIndex(nums, midIndex + 1, endIndex, target);
            } else {
                return findIndex(nums, startIndex, midIndex - 1, target);
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 }, target = 3;
        System.out.println(findIndex(nums, 0, nums.length - 1, target));
    }

}
