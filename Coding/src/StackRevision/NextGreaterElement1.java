package StackRevision;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack();
        int nums1[] = { 4, 1, 2 };
        int nums2[] = { 1, 3, 4, 2 };
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curItem = nums2[i];
            if (st.empty()) {
                hm.put(curItem, -1);
            } else {
                while (!st.empty() && st.peek() <= curItem) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    hm.put(curItem, -1);
                } else {
                    hm.put(curItem, st.peek());
                }

            }
            st.push(curItem);
        }
        int result[] = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
            result[i] = hm.get(nums1[i]);
        }
        // for (int i : result) {
        // System.out.println(i);
        // }
    }

}
