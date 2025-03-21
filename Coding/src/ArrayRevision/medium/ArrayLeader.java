package ArrayRevision.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayLeader {

    public static void main(String[] args) {
        int arr[] = { 30, 10, 10, 5 };
        int rightMax = -1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                result.add(arr[i]);
                rightMax = arr[i];
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }

}
