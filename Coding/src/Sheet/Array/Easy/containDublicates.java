package Sheet.Array.Easy;

import java.util.HashSet;

import Stack.pushBottom;

public class containDublicates {

    public static boolean findContainDublicates(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i])) {
                return true;
            }
            hs.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(findContainDublicates(arr));
    }

}
