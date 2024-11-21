package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutationKthSubSequence {

    public static int findFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }

    public static String findPermutation(List<Integer> arr, String finalResult, int k) {
        if (arr.size() <= 0) {
            return finalResult;
        }
        int totalNumberFormed = findFactorial(arr.size() - 1);
        for (int i = 0; i < arr.size(); i++) {
            int currentElement = arr.get(i);
            if (totalNumberFormed < k) {
                k = k - totalNumberFormed;
            } else {
                finalResult += currentElement;
                arr.remove(i);
                Collections.sort(arr);
                return findPermutation(arr, finalResult, k);

            }
        }
        return "";
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        System.out.println(findPermutation(arr, "", k));

    }

}
