package top150InterviewProblem.TwoPointer;

import java.util.HashMap;
import java.util.HashSet;

public class twoSum {

    public static int[] findElement(int numbers[], int target) {
        int start = 0;
        int end = numbers.length - 1;
        int result[] = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }

        }
        return result;
    }

    public static int[] findElementByHashing(int numbers[], int target) {
        HashMap<Integer, Integer> hs = new HashMap();
        int result[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (hs.containsKey(target - numbers[i])) {
                result[0] = hs.get(target - numbers[i]);
                result[1] = i;
                return result;
            } else {
                hs.put(numbers[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 7, 11, 15 };
        int target = 9;

    }

}
