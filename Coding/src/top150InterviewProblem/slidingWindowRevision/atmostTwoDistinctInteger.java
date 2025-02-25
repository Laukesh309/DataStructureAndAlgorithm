package top150InterviewProblem.slidingWindowRevision;

import java.util.HashMap;
import java.util.HashSet;

public class atmostTwoDistinctInteger {

    public static int findMaxSubArray(int arr[]) {
        int left = 0;
        int maxSize = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int right = 0; right < arr.length; right++) {
            if (!hs.containsKey(arr[right]) && hs.size() >= 2) {
                while (hs.size() >= 2) {
                    hs.put(arr[left], hs.get(arr[left]) - 1);
                    if (hs.get(arr[left]) == 0) {
                        hs.remove(arr[left]);
                    }
                    left++;
                }
            }
            maxSize = Math.max(maxSize, right - left + 1);
            hs.put(arr[right], hs.getOrDefault(arr[right], 0) + 1);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 2, 2, 3, 4, 4, 4 };
        System.out.println(findMaxSubArray(arr));
    }

}
