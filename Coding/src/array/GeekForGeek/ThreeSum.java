package array.GeekForGeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import HashSet.hashSet;

public class ThreeSum {
    public static List<List<Integer>> findIndex(int arr[], int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            int targetSum = target - arr[i];
            HashSet<Integer> hs = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (hs.contains(targetSum - arr[j])) {
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(arr[i]);
                    tempResult.add(targetSum - arr[j]);
                    tempResult.add(arr[j]);
                    Collections.sort(tempResult);
                    result.add(tempResult);
                } else {
                    hs.add(arr[j]);
                }
            }

        }
        HashSet<List<Integer>> hs = new HashSet<>();
        for (List<Integer> item : result) {
            hs.add(item);
        }
        result.clear();
        for (List<Integer> list : hs) {
            result.add(list);
        }
        return result;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static List<List<Integer>> findValue(int arr[], int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int targetSum = target - arr[i];
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                if ((arr[start] + arr[end]) == targetSum) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[start]);
                    tempList.add(arr[end]);
                    result.add(tempList);
                    start++;
                    while (start < end && (arr[start] == arr[start - 1])) {
                        System.out.println("whh");
                        start++;
                    }
                    while (end > start && (arr[end - 1] == arr[end])) {
                        System.out.println("error");
                        end--;

                    }
                } else if ((arr[start] + arr[end]) < targetSum) {
                    System.out.println("srr");
                    start++;
                } else {
                    System.out.println("error");
                    end--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 0 };
        int target = 0;
        // System.out.println(findIndex(arr, target));
        System.out.println(findValue(arr, target));
    }

}
