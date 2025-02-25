package top150InterviewProblem.DPProblem.easy;

import java.util.ArrayList;
import java.util.Stack;

public class plus {

    public static void printArray(int result[]) {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int digit[] = { 9, 9, 9 };
        Stack<Integer> st = new Stack<>();
        int remainder = 0;
        int qus = 1;
        for (int i = digit.length - 1; i >= 0; i--) {
            int number = digit[i] + qus;
            remainder = (number) % 10;
            qus = number / 10;
            st.add(remainder);
        }
        if (qus == 1) {
            st.add(qus);
        }

        int result[] = new int[st.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = st.pop();
        }
        // printArray(result);
        // System.out.println(st);
        return result;
    }

}
