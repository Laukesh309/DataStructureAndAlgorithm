package array;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class findLargestPairSum {

    public static int findLargestPairSum(int arr[]) {
        if (arr.length < 2) {
            return -1;
        }
        HashSet<Integer> hs = new HashSet<>();
        hs.add(Integer.MIN_VALUE);
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Collections.max(hs));
            maxValue = Math.max(maxValue, arr[i] + Collections.max(hs));
            hs.add(arr[i]);
        }
        return maxValue;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2, 2 };
        System.out.println(findLargestPairSum(arr));
    }

}
