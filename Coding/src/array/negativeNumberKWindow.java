package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class negativeNumberKWindow {

    public static void findNegativeNumber(int arr[], int k) {
        int start = 0;
        int end = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> tempResult = new LinkedList<>();
        while (end < arr.length) {
            if (arr[end] < 0) {
                tempResult.add(arr[end]);
            }
            if (end - start + 1 < k) {
                end++;
            } else {
                if (!tempResult.isEmpty()) {
                    int peekElement = tempResult.peek();
                    result.add(peekElement);
                    if (peekElement == arr[start]) {
                        tempResult.remove();
                    }
                }
                start++;
                end++;
            }

        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        findNegativeNumber(arr, 3);

    }
}
