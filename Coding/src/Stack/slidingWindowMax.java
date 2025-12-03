package Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class slidingWindowMax {

    public static void findMaxElement(int nums[], int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];

            while (!dq.isEmpty() && dq.peek() <= (i - k)) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && currentElement > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                result.add(nums[dq.peekFirst()]);
            }

        }
        System.out.println(result);
        int finalResult[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, -1 };
        int k = 1;
        findMaxElement(nums, k);
    }

}
