package top150InterviewProblem.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class findKPairWithSmallestSum {

    public static void printSmallestPair(int nums1[], int nums2[], int k) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int item : nums1) {
            pq1.add(item);
        }
        for (int item : nums2) {
            pq2.add(item);
        }
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(pq1.peek());
        temp1.add(pq2.peek());
        result.add(temp1);

        int firstPointer = 1;
        int secondPointer = 1;
        int counter = 1;
        while (firstPointer < nums1.length && secondPointer < nums2.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            int firstValue = nums1[firstPointer];
            int secondValue = nums2[secondPointer];
            int firstPeekElement = pq1.peek();
            int secondPeekElement = pq2.peek();
            if ((firstValue + secondPeekElement) < (secondValue + firstPeekElement)) {
                firstPointer++;
                temp.add(firstValue);
                temp.add(secondPeekElement);
            } else {
                temp.add(firstPeekElement);
                temp.add(secondValue);
                secondPointer++;
            }
            counter++;
            result.add(temp);
            if (counter >= k) {
                System.out.println(result);
                return;
            }
        }
        System.out.println(result);
        return;

    }

    public static void main(String[] args) {
        // int nums1[] = { 1, 7, 11 }, nums2[] = { 2, 4, 6 };
        // int nums1[] = { 1, 1, 2 }, nums2[] = { 1, 2, 3 };
        int nums1[] = { 1, 2, 4, 5, 6 }, nums2[] = { 3, 5, 7, 9 };
        int k = 20;
        printSmallestPair(nums1, nums2, k);
    }

}
