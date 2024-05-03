package HashMap;

import java.util.HashMap;
import java.util.Set;

public class findIntergergreate {

    public static void findAllElement(int arr[], int key) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (hm.containsKey(arr[i])) {
            // hm.put(arr[i], hm.get(arr[i]) + 1);
            // } else {
            // hm.put(arr[i], 1);
            // }
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> keySet = hm.keySet();
        System.out.println("key = " + key);
        for (Integer hashKey : keySet) {
            if (hm.get(hashKey) > key) {
                System.out.println(hashKey + "   " + hm.get(hashKey));
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        int arr2[] = { 1, 2 };
        findAllElement(arr2, arr2.length / 3);

    }

}
