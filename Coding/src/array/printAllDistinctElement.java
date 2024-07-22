package array;

// https://www.geeksforgeeks.org/problems/make-a-distinct-digit-array2007/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class printAllDistinctElement {

    public static int[] findUniquDigit(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            while (value > 0) {
                hs.add(value % 10);
                value = value / 10;
            }
        }
        int result[] = new int[hs.size()];
        int i = 0;
        for (int item : hs) {
            result[i++] = item;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 131, 11, 48 };
        findUniquDigit(arr);
    }

}
