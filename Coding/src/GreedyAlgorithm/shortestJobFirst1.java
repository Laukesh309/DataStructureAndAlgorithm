package GreedyAlgorithm;

import java.util.Arrays;

public class shortestJobFirst1 {

    public static void main(String[] args) {

        int bt[] = { 4, 3, 7, 1, 2 };
        int wt[] = new int[bt.length];
        Arrays.sort(bt);
        wt[0] = 0;
        for (int i = 1; i < bt.length; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }
        int sum = 0;
        for (int i = 0; i < wt.length; i++) {
            sum = sum + wt[i];
        }

    }

}
