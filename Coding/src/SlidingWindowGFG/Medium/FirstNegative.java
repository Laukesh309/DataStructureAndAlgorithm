package SlidingWindowGFG.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegative {

    public static List<Integer> findNegativeNumber(int arr[], int k) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                que.add(arr[i]);
            }
        }
        if (que.size() > 0) {
            result.add(que.peek());
        } else {
            result.add(0);
        }
        for (int i = k; i < arr.length; i++) {
            int currentElement = arr[i];
            if (currentElement < 0) {
                que.add(currentElement);
            }
            int leftElement = arr[left++];
            if (!que.isEmpty() && que.peek() == leftElement) {
                que.poll();
            }
            if (que.isEmpty()) {
                result.add(0);
            } else {
                result.add(que.peek());
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = { -8, 2, 3, -6, 10 };
        int k = 2;
        System.out.println(findNegativeNumber(arr, k));
    }

}
