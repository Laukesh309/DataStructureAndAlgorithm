package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import top150InterviewProblem.TwoPointer.threeSum;

public class ThreeSumRevision {

    public static void findPair(ArrayList<Integer> tempArray, int firstIndex, int secondIndex, int target,
            List<List<Integer>> finalResult, int currentIndex) {
        // System.out.println(target);
        if (firstIndex >= secondIndex) {
            return;
        }
        int sum = tempArray.get(firstIndex) + tempArray.get(secondIndex);
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.add(-target);
            temp.add(tempArray.get(firstIndex));
            temp.add(tempArray.get(secondIndex));
            finalResult.add(temp);
            firstIndex++;
            secondIndex--;
            while (firstIndex < secondIndex && tempArray.get(firstIndex).equals(tempArray.get(firstIndex - 1))) {
                firstIndex++;
            }
            while (secondIndex > firstIndex && tempArray.get(secondIndex).equals(tempArray.get(secondIndex + 1))) {
                secondIndex--;
            }
            findPair(tempArray, firstIndex, secondIndex, target, finalResult, currentIndex);
        } else if (sum > target) {
            findPair(tempArray, firstIndex, secondIndex - 1, target, finalResult, currentIndex);
        } else {
            findPair(tempArray, firstIndex + 1, secondIndex, target, finalResult, currentIndex);
        }

    }

    public static List<List<Integer>> threeSum(int[] sum) {

        ArrayList<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < sum.length; i++) {
            tempArray.add(sum[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < tempArray.size() - 1; i++) {
            if (i > 0 && tempArray.get(i).equals(tempArray.get(i - 1))) {
                continue;
            }
            System.out.println(tempArray.get(i));
            int target = tempArray.get(i);
            findPair(tempArray, i + 1, tempArray.size() - 1, -target, result, i);

        }
        System.out.println(result);

        return new ArrayList<>();

    }

    public static void main(String[] args) {
        int sum[] = { 1, 2, 0, 1, 0, 0, 0, 0 };
        Arrays.sort(sum);
        threeSum(sum);

    }

}
