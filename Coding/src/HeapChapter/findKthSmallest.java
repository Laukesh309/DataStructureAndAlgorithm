package HeapChapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class findKthSmallest {

    static class Pair implements Comparable<Pair> {
        int firstElement;
        int secondElement;
        int sum;

        Pair(int firstElement, int secondElement, int sum) {
            this.firstElement = firstElement;
            this.secondElement = secondElement;
            this.sum = this.firstElement + this.secondElement;
        }

        public int compareTo(Pair p2) {
            return this.sum - p2.sum;
        }

    }

    public static void findTotalElement(int nums1[], int nums2[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<List<Integer>> tempSet = new HashSet<>();
        int firstIndex = 0;
        int secondIndex = 0;
        int sum = nums1[firstIndex] + nums2[secondIndex];
        pq.add(new Pair(firstIndex, secondIndex, sum));
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(firstIndex);
        temp.add(secondIndex);
        tempSet.add(temp);
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            Pair curPair = pq.poll();
            List<Integer> tempResult = new ArrayList<>();
            int curFirstIndex = curPair.firstElement;
            int curSecondIndex = curPair.secondElement;
            tempResult.add(nums1[curFirstIndex]);
            tempResult.add(nums2[curSecondIndex]);
            result.add(tempResult);
            int nextFirstIndex = curFirstIndex + 1;
            int nextSecondIndex = curSecondIndex + 1;
            List<Integer> tempFirstResult = new ArrayList<>();
            tempFirstResult.add(curFirstIndex);
            tempFirstResult.add(nextSecondIndex);
            if (!tempSet.contains(tempFirstResult) && curFirstIndex < nums1.length && nextSecondIndex < nums2.length) {
                tempSet.add(tempFirstResult);
                pq.add(new Pair(curFirstIndex, nextSecondIndex, nums1[curFirstIndex] + nums2[nextSecondIndex]));
            }
            List<Integer> tempSecondResult = new ArrayList<>();
            tempSecondResult.add(nextFirstIndex);
            tempSecondResult.add(curSecondIndex);
            if (!tempSet.contains(tempSecondResult) && nextFirstIndex < nums1.length && curSecondIndex < nums2.length) {
                tempSet.add(tempSecondResult);
                pq.add(new Pair(nextFirstIndex, curSecondIndex, nums1[nextFirstIndex] + nums2[curSecondIndex]));
            }
            k--;
        }

    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2 };
        int nums2[] = { 1, 2, 3 };
        int k = 2;
        findTotalElement(nums1, nums2, k);

    }

}
