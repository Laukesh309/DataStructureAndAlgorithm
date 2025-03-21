package ArrayRevision;

public class missingNumber {

    public static void main(String[] args) {
        int nums[] = { 3, 0, 1 };
        int totalNumber = nums.length + 1;
        int totalSum = totalNumber * (nums.length) / 2;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
        }

        System.out.println(totalSum - currentSum);

    }

}
