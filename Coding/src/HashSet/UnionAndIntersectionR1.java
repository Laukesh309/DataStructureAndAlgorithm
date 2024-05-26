package HashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionAndIntersectionR1 {

    public static void findUnion(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        System.out.println(hs);
    }

    public static void findIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> hs1 = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            hs1.add(arr1[i]);
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            hs2.add(arr2[i]);
        }
        int count = 0;
        for (Integer value : hs1) {
            if (hs2.contains(value)) {
                result.add(value);
                count++;
                hs2.remove(value);
            }

        }
        System.out.println(count);
        System.out.println(result);
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        findUnion(arr1, arr2);
        findIntersection(arr1, arr2);
    }

}
