package top150InterviewProblem.slidingWindow;

import java.util.HashMap;

public class FruitIntoBasket {

    public static int findMax(int arr[], int k) {
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int max = 0;
        while (right < arr.length) {
            int currentValue = arr[right];
            hs.put(currentValue, hs.getOrDefault(currentValue, 0) + 1);
            while (hs.size() > k) {
                int leftValue = arr[left];
                hs.put(leftValue, hs.get(leftValue) - 1);
                if (hs.get(leftValue) == 0) {
                    hs.remove(leftValue);
                }
                left++;
            }
            if (hs.size() <= k) {
                max = Math.max(max, right - left + 1);
            }

            right++;

        }
        return max;

    }

    public static int findMaxValue(int arr[], int k) {
        int left = 0;
        int right = 0;
        int maxValue = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        while (right < arr.length) {
            int currentRightValue = arr[right];
            if (hs.size() > k) {
                int leftValue = arr[left];
                hs.put(leftValue, hs.get(leftValue) - 1);
                if (hs.get(leftValue) == 0) {
                    hs.remove(leftValue);
                }
                left++;
            } else {
                hs.put(currentRightValue, hs.getOrDefault(currentRightValue, 0) + 1);
                maxValue = Math.max(maxValue, right - left + 1);
                right++;
            }

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        int k = 2;
        System.out.println(findMax(arr, k));
        System.out.println(findMaxValue(arr, k));

    }

}
