package HashSet;

import java.util.HashSet;

public class UnionSet {

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

    public static void main(String[] args) {

        int arr1[] = { 7, 3, 4 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        findUnion(arr1, arr2);

    }
}
