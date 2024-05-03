package HashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class intersection {

    public static void findInterSection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hs.contains(arr2[i])) {
                result.add(arr2[i]);
                hs.remove(arr2[i]);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 4, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        findInterSection(arr1, arr2);
    }

}
