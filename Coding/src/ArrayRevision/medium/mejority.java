package ArrayRevision.medium;

import java.util.HashMap;

public class mejority {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 3 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        int resultFrequence = 0;
        int resultElement = 0;
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            int currentFrequence = hm.get(arr[i]);
            if (currentFrequence > resultFrequence) {
                resultFrequence = currentFrequence;
                resultElement = arr[i];
            }

        }
        System.out.println(resultElement);
    }

}
