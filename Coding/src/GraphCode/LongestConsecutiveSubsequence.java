package GraphCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestConsecutiveSubsequence {

    public static int findElement(HashMap<Integer, Integer> result, int nextNumber, HashSet<Integer> tempSet) {
        if (result.containsKey(nextNumber)) {
            return result.get(nextNumber);
        }
        if (!tempSet.contains(nextNumber)) {
            return 0;
        }
        tempSet.remove(nextNumber);
        int nextValue = 1 + findElement(result, nextNumber + 1, tempSet);
        result.put(nextNumber, nextValue);
        return nextValue;

    }

    public static int findConsecutive(HashMap<Integer, Integer> result, int num[]) {
        HashSet<Integer> temp = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            temp.add(num[i]);
        }
        ArrayList<Integer> tempResult = new ArrayList<>(temp);
        for (int i = 0; i < tempResult.size(); i++) {
            int currElement = tempResult.get(i);
            int curResult = 1 + findElement(result, currElement + 1, temp);
            result.put(currElement, curResult);
        }
        int max = Collections.max(result.values());
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        HashMap<Integer, Integer> result = new HashMap<>();
        System.out.println(findConsecutive(result, nums));

    }

}
