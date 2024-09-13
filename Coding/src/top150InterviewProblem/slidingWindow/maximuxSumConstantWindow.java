package top150InterviewProblem.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class maximuxSumConstantWindow {

    public static int maxSum(int arr[], int k) {
        Queue<Integer> que = new LinkedList<>();
        int end = 0;
        int sum = 0;
        int maxSum = 0;
        while (end < arr.length) {
            sum += arr[end];
            que.add(arr[end]);
            if (que.size() > k) {
                int frontElment = que.remove();
                sum -= frontElment;
                maxSum = Math.max(maxSum, sum);
            } else {
                maxSum = sum;
            }
            System.out.println(maxSum);
            end++;

        }
        return maxSum;
    }

    public static int findMaximumWindow(int arr[], int start, int end, int result, int k) {
        if (end >= arr.length) {
            return end - start + 1;
        }
        if (result <= k) {
            int maxLenght = findMaximumWindow(arr, start, end + 1, result + arr[end], k);
            return Math.max(end - start + 1, maxLenght);
        } else {
            return findMaximumWindow(arr, start + 1, end, result - arr[start], k);

        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 1, 7, 10 };
        System.out.println(findMaximumWindow(arr, 0, 0, 0, 14));
    }

}
