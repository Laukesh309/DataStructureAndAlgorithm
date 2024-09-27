package GreedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

import HeapChapter.priorityQueue;

public class maximizeCookies {

    public static int getMaxCookie(int g[], int s[]) {
        Arrays.sort(g);
        Arrays.sort(s);
        int firstPointer = 0;
        int secondPointer = 0;
        int result = 0;

        while (firstPointer < g.length && secondPointer < s.length) {
            if (g[firstPointer] <= s[secondPointer]) {
                firstPointer++;
                result++;
            }
            secondPointer++;

        }
        return result;
    }

    public static void main(String[] args) {
        int g[] = { 1, 2 };
        int s[] = { 1, 2, 3 };
        System.out.println(getMaxCookie(g, s));
    }

}
