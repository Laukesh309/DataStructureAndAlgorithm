// https://leetcode.com/problems/asteroid-collision/description/

package StackRevision;

import java.util.Stack;

public class astroidCollision {

    public static void findAstroid(int arr[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            while (!st.empty() && currentElement < 0 && st.peek() > 0) {
                if (st.peek() < Math.abs(currentElement)) {
                    st.pop();
                } else if (st.peek() == Math.abs(currentElement)) {
                    currentElement = 0;
                    st.pop();
                    break;
                } else {
                    currentElement = 0;
                    break;
                }

            }
            if (currentElement != 0) {
                st.push(currentElement);
            }
        }
        int result[] = new int[st.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = st.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, -5 };
        findAstroid(arr);
    }

}
