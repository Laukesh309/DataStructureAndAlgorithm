package TwoDimensionMatrix;

import java.util.HashMap;

public class subArrayEqualToK {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        int k = 3;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int totalResult = 0;
        hs.put(0, 1);
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
            if (hs.containsKey(totalSum - k)) {
                totalResult = totalResult + hs.get(totalSum - k);

            }
            hs.put(totalSum, hs.getOrDefault(totalSum, 0) + 1);
        }
        System.out.println(totalResult);
    }

}
