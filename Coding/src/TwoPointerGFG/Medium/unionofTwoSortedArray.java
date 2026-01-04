package TwoPointerGFG.Medium;

import java.util.ArrayList;

public class unionofTwoSortedArray {

    public static ArrayList<Integer> findSorted(int a[], int b[]) {
        int firstPointer = 0;
        int secondPointer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (firstPointer < a.length && secondPointer < b.length) {
            while (firstPointer - 1 >= 0 && firstPointer < a.length && a[firstPointer] == a[firstPointer - 1]) {
                firstPointer++;
            }
            while (secondPointer - 1 >= 0 && secondPointer < b.length && b[secondPointer] == b[secondPointer - 1]) {
                secondPointer++;
            }
            if (firstPointer < a.length && secondPointer < b.length) {
                if (a[firstPointer] == b[secondPointer]) {
                    result.add(a[firstPointer++]);
                    secondPointer++;
                } else if (a[firstPointer] > b[secondPointer]) {
                    result.add(b[secondPointer]);
                    secondPointer++;
                } else {
                    result.add(a[firstPointer]);
                    firstPointer++;
                }
            }

        }
        System.out.println("testing2" + result);
        while (firstPointer < a.length) {
            while (firstPointer < a.length && firstPointer - 1 >= 0 && a[firstPointer] == a[firstPointer - 1]) {
                firstPointer++;
            }
            if (firstPointer < a.length) {
                result.add(a[firstPointer++]);
            }

        }
        while (secondPointer < b.length) {
            while (secondPointer < b.length && secondPointer - 1 >= 0 && b[secondPointer] == b[secondPointer - 1]) {
                secondPointer++;
            }
            if (secondPointer < b.length) {
                result.add(b[secondPointer++]);
            }

        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 1, 1, 1 };
        int b[] = { 2, 2, 2, 2, 2 };
        findSorted(a, b);

    }

}
