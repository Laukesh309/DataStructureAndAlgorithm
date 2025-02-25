package top150InterviewProblem.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

    public static List<List<Integer>> findElement(int arr[]) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int target = arr[i];
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                List<Integer> temp = new ArrayList<>();
                if (arr[start] + arr[end] + target == 0) {
                    temp.add(target);
                    temp.add(arr[start]);
                    temp.add(arr[end]);
                    result.add(temp);
                    start++;
                    end--;
                    while (start < arr.length && arr[start] == arr[start - 1]) {
                        start++;
                    }
                    while (end >= 0 && arr[end] == arr[end + 1]) {
                        end--;
                    }
                } else if (arr[start] + arr[end] + target > 0) {
                    end--;
                } else {
                    start++;
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 0, 0 };
        System.out.println(findElement(arr));

    }

}
