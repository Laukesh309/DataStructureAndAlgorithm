package BinarySearchRevision;

public class searchIndex {

    public static int findIndex(int nums[], int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] == target) {
            return midIndex;
        }
        if (nums[midIndex] < target) {
            return findIndex(nums, midIndex + 1, endIndex, target);
        } else {
            return findIndex(nums, startIndex, midIndex - 1, target);
        }

    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 6 };
        int target = 5;

        System.out.println(findIndex(nums, 0, nums.length - 1, target));
        Integer.M
    }

}
