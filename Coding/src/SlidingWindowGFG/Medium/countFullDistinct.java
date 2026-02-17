package SlidingWindowGFG.Medium;

import java.util.HashMap;
import java.util.HashSet;

public class countFullDistinct {

    public static int findTotalDistinct(int arr[], int distinct) {
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int currentDistinct = 0;
        int totalSubArray = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i])) {
                currentDistinct++;
            }
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            while (currentDistinct >= distinct) {
                hm.put(arr[left], hm.get(arr[left]) - 1);
                if (hm.get(arr[left]) == 0) {
                    currentDistinct--;
                    hm.remove(arr[left]);
                }
                left++;
            }
            totalSubArray = totalSubArray + i - left + 1;
        }
        System.out.println(totalSubArray);
        return totalSubArray;

    }

    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 2, 1, 3, 2, 3 };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        int totalDistinct = hs.size();
        int left = findTotalDistinct(arr, totalDistinct);
        int right = findTotalDistinct(arr, totalDistinct + 1);
        int result = right - left;

    }

}
