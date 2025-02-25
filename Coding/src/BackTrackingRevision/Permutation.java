package BackTrackingRevision;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void findAllPermutation(int nums[], int currentIndex, List<Integer> result,
            List<List<Integer>> finalResult) {
        if (currentIndex >= nums.length) {
            List<Integer> tempValue = new ArrayList<>(result);
            finalResult.add(tempValue);
            return;
        }

        for (int i = currentIndex; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[currentIndex];
            nums[currentIndex] = temp;
            result.add(nums[currentIndex]);
            findAllPermutation(nums, currentIndex + 1, result, finalResult);
            result.remove(result.size() - 1);
            nums[currentIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        List<List<Integer>> finalResult = new ArrayList<>();
        findAllPermutation(nums, 0, new ArrayList<>(), finalResult);
        System.out.println(finalResult);
    }

}
