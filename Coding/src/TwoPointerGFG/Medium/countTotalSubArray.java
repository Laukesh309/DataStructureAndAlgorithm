package TwoPointerGFG.Medium;

import java.util.HashMap;

public class countTotalSubArray {

    public static int findTotalPair(int arr[], int k) {
        int total = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int currentItem = arr[i];
            int absDiff1 = currentItem - k;
            int absDiff2 = k + currentItem;
            if (hm.containsKey(absDiff1)) {
                System.err.println("testing1" + currentItem);
                total = total + hm.get(absDiff1);
            }
            if (hm.containsKey(absDiff2)) {
                System.out.println("testing2" + currentItem);
                total = total + hm.get(absDiff2);
            }

            hm.put(currentItem, hm.getOrDefault(currentItem, 0) + 1);
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 1, 4, 5 };
        int k = 3;
        System.out.println(findTotalPair(arr, k));
    }

}
