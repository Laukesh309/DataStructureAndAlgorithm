package ArrayRevision;

import java.util.ArrayList;

public class FindUnion {

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int first = 0;
        int second = 0;
        while (first < a.length && second < b.length) {
            if (a[first] < b[second]) {
                if (!result.contains(a[first])) {
                    result.add(a[first]);
                }
                first++;

            } else {
                if (!result.contains(b[second])) {
                    result.add(b[second]);
                }
                second++;
            }
        }
        while (first < a.length) {
            if (!result.contains(a[first])) {
                result.add(a[first]);
            }
            first++;
        }
        while (second < b.length) {
            if (!result.contains(b[second])) {
                result.add(b[second]);
            }
            second++;
        }
        return result;

    }

    public static ArrayList<Integer> findUnionSecond(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < a.length && secondIndex < b.length) {
            while (result.size() > 0 && firstIndex < a.length && a[firstIndex] == result.get(result.size() - 1)) {
                firstIndex++;
            }
            while (result.size() > 0 && secondIndex < b.length && b[secondIndex] == result.get(result.size() - 1)) {
                secondIndex++;
            }
            if (firstIndex < a.length && secondIndex < b.length) {
                if (a[firstIndex] < b[secondIndex]) {
                    result.add(a[firstIndex]);
                    firstIndex++;
                } else if (a[firstIndex] > b[secondIndex]) {
                    result.add(b[secondIndex]);
                    secondIndex++;
                } else {
                    result.add(a[firstIndex]);
                    firstIndex++;
                    secondIndex++;

                }
            }

        }
        while (firstIndex < a.length) {
            if (a[firstIndex] != a[firstIndex - 1]) {
                result.add(a[firstIndex]);
            }
            firstIndex++;

        }
        while (secondIndex < b.length) {
            if (b[secondIndex] != b[secondIndex - 1]) {
                result.add(b[secondIndex]);
            }
            secondIndex++;

        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int b[] = { 1, 2, 3, 6, 7 };
        // System.out.println(findUnion(a, b));
        System.out.println(findUnionSecond(a, b));

    }

}
