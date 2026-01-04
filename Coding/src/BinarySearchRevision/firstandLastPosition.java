package BinarySearchRevision;

public class firstandLastPosition {

    public static void findElement(int nums[], int target, int startIndex, int endIndex, int result[]) {
        if (startIndex > endIndex) {
            return;
        }
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] == target) {
            result[0] = Math.min(result[0], midIndex);
            result[1] = Math.max(result[1], midIndex);
            findElement(nums, target, midIndex + 1, endIndex, result);
            findElement(nums, target, startIndex, midIndex - 1, result);
        }
        if (nums[midIndex] > target) {
            findElement(nums, target, startIndex, midIndex - 1, result);
        } else {
            findElement(nums, target, midIndex + 1, endIndex, result);
        }

    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int result[] = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        findElement(nums, target, 0, nums.length - 1, result);
        System.out.println(result[0] + " " + result[1]);
        if (result[0] == Integer.MAX_VALUE) {
            result[0] = -1;
        }
        if (result[1] == Integer.MIN_VALUE) {
            result[1] = -1;
        }

    }

}