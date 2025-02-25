package top150InterviewProblem.slidingWindowRevision;

import java.util.HashMap;

public class subArrayWithKdifferentInteger {

    public static int findKDifferentInteger(int nums[], int k) {
        if (k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> hs = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            int currentElement = nums[right];
            hs.put(currentElement, hs.getOrDefault(currentElement, 0) + 1);
            while (hs.size() > k) {
                int leftElement = nums[left++];
                hs.put(leftElement, hs.get(leftElement) - 1);
                if (hs.get(leftElement) == 0) {
                    hs.remove(leftElement);
                }
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 3, 4 };
        int k = 3;
        int leftResult = findKDifferentInteger(nums, k);
        int rightResult = findKDifferentInteger(nums, k - 1);
        System.out.println(leftResult - rightResult);
    }

}
