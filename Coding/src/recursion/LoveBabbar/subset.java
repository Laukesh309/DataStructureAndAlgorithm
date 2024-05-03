package recursion.LoveBabbar;

import java.util.*;

public class subset {

    public static void findAllSubSet(int arr[], ArrayList<Integer> list, int inititalPointer) {
        if (inititalPointer >= arr.length) {
            System.out.println(list);
            return;
        }
        ArrayList<Integer> list2 = new ArrayList<>(list);
        ArrayList<Integer> list1 = new ArrayList<>(list);
        list2.add(arr[inititalPointer]);
        findAllSubSet(arr, list2, inititalPointer + 1);
        findAllSubSet(arr, list1, inititalPointer + 1);

    }

    public static void main(String[] args) {
        int list[] = { 1, 2, 3 };
        findAllSubSet(list, new ArrayList<Integer>(), 0);

    }

}
