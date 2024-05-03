package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {

    public static void main(String[] args) {
        Integer arr[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(arr, Comparator.reverseOrder());
        int totalCoin = 0;
        int totalValue = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= totalValue) {
                while (arr[i] <= totalValue) {
                    totalCoin++;
                    ans.add(arr[i]);
                    totalValue = totalValue - arr[i];
                }
                ;
            }
        }
        System.out.println(ans);
        System.out.println(totalCoin);
    }

}
