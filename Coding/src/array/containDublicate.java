package array;

import java.util.HashMap;
import java.util.HashSet;

public class containDublicate {

    public static boolean findDublicate(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int item : arr) {
            if (hm.containsKey(item)) {
                return true;
            } else {
                hm.put(item, 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        if (hs.size() == arr.length) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
        System.out.println(findDublicate(arr));
    }

}
