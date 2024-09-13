package top150InterviewProblem.slidingWindow;

import java.util.HashMap;

public class maximumConsecutiveOnce {

    public static int findMaximumCon(int arr[], int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        int zero = 0;
        while (right < arr.length) {
            hs.put(arr[right], hs.getOrDefault(arr[right], 0) + 1);
            while (arr[right] == 0 && hs.containsKey(arr[right]) && hs.get(arr[right]) > 2) {
                if (arr[left] == 0) {
                    hs.put(arr[right], hs.get(arr[right]) - 1);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;

        }
        System.out.println("maxValue -->" + max);
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(findMaximumCon(arr, k));
    }

}
