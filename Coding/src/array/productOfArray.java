package array;

public class productOfArray {

    public static void print(int result[]) {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        int result[] = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = suffix * result[i];
            suffix = suffix * nums[i];
        }
        print(result);

    }

}
