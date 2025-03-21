package ArrayRevision.medium;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = hm.get(target - nums[i]);
                return result;

            }
            hm.put(nums[i], i);
        }

    }

}
