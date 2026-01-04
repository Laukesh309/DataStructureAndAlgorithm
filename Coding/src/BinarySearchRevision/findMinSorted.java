package BinarySearchRevision;

public class findMinSorted {

    public static int findMin(int nums[], int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return nums[startIndex];
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] > nums[endIndex]) {
            return findMin(nums, startIndex + 1, endIndex);
        } else {
            if (nums[startIndex] < nums[endIndex]) {
                return nums[startIndex];
            } else {
                return findMin(nums, startIndex, midIndex);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums, 0, nums.length - 1));
    }

}
