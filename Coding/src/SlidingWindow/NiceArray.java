package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class NiceArray {

    public static int findArray(int nums[], int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        HashMap<Integer, Integer> st = new HashMap<>();
        while (right < nums.length) {
            st.put(nums[right], st.getOrDefault(nums[right], 0) + 1);
            while (st.keySet().size() > k) {
                st.put(nums[left], st.get(nums[left]) - 1);
                if (st.get(nums[left]) == 0) {
                    st.remove(nums[left]);
                }
                left++;
            }
            sum = sum + right - left + 1;
            right++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 2, 3 };
        int k = 2;
        int left = findArray(nums, k);
        int right = findArray(nums, k - 1);
        System.out.println(left + " " + right);

    }

}
