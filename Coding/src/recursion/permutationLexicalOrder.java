package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutationLexicalOrder {

    public static void printArray(int result[]) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "");
        }
        System.out.println();
    }

    public static int findTotalPermutaion(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * findTotalPermutaion(n - 1);
    }

    public static void getAllPermutation(int result[], int currentIndex, List<String> finalResult) {

        if (currentIndex >= result.length) {
            String finalString = "";
            for (int i = 0; i < result.length; i++) {
                finalString += result[i];
            }

            finalResult.add(finalString);
            return;
        }
        for (int i = currentIndex; i < result.length; i++) {
            int temp = result[currentIndex];
            result[currentIndex] = result[i];
            result[i] = temp;
            getAllPermutation(result, currentIndex + 1, finalResult);
            result[i] = result[currentIndex];
            result[currentIndex] = temp;

        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        int totalPermutation = findTotalPermutaion(n);
        int singlePermutation = findTotalPermutaion(n - 1);
        List<String> finalResult = new ArrayList<>();
        getAllPermutation(result, 0, finalResult);
        Collections.sort(finalResult);
        System.out.println(finalResult);

    }
}
