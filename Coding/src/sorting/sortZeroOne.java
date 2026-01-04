package sorting;

public class sortZeroOne {

    public static void sort(int nums[]) {
        int firstPointer = 0;
        int secondPointer = 0;
        int lastPointer = nums.length - 1;
        while (secondPointer < lastPointer) {
            while (lastPointer >= secondPointer && nums[lastPointer] == 2) {
                lastPointer--;
            }
            while (secondPointer < lastPointer && nums[secondPointer] == 1) {
                secondPointer++;
            }
            if (secondPointer < lastPointer && nums[secondPointer] == 0) {
                int temp = nums[secondPointer];
                nums[secondPointer++] = nums[firstPointer];
                nums[firstPointer++] = temp;
            }
            if (secondPointer < lastPointer && nums[secondPointer] == 2) {
                int temp = nums[secondPointer];
                nums[secondPointer] = nums[lastPointer];
                nums[lastPointer--] = temp;
            }

        }
        print(nums);
    }

    public static void print(int nums[]) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sort(nums);
    }

}
