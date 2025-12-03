package StackRevision;

import java.util.Stack;

public class sumOfSubArrayRanges {

    public static void findPrevMin(int arr[], int prevMin[]) {
        Stack<Integer> st = new Stack<>();
        int currentIndex = 0;
        while (currentIndex < arr.length) {
            int curElement = arr[currentIndex];
            while (!st.empty() && arr[st.peek()] >= curElement) {
                st.pop();
            }
            if (st.empty()) {
                prevMin[currentIndex] = -1;
            } else {
                prevMin[currentIndex] = st.peek();
            }
            st.push(currentIndex);
            currentIndex++;

        }
    }

    public static void findNextMin(int arr[], int nextMin[]) {
        Stack<Integer> st = new Stack<>();
        int currentIndex = arr.length - 1;
        while (currentIndex >= 0) {
            int curElement = arr[currentIndex];
            while (!st.empty() && arr[st.peek()] >= curElement) {
                st.pop();
            }
            if (st.empty()) {
                nextMin[currentIndex] = arr.length;
            } else {
                nextMin[currentIndex] = st.peek();
            }

            st.push(currentIndex);
            currentIndex--;
        }
    }

    public static void findPrevMax(int arr[], int prevMax[]) {
        Stack<Integer> st = new Stack<>();
        int currentIndex = 0;
        while (currentIndex < arr.length) {
            int curElement = arr[currentIndex];
            while (!st.empty() && arr[st.peek()] <= curElement) {
                st.pop();
            }
            if (st.empty()) {
                prevMax[currentIndex] = -1;
            } else {
                prevMax[currentIndex] = st.peek();
            }

            st.push(currentIndex);
            currentIndex++;
        }
    }

    public static void findNextMax(int arr[], int nextMax[]) {
        Stack<Integer> st = new Stack<>();
        int currentIndex = arr.length - 1;
        while (currentIndex >= 0) {
            int curElement = arr[currentIndex];
            while (!st.empty() && arr[st.peek()] <= curElement) {
                st.pop();
            }
            if (st.empty()) {
                nextMax[currentIndex] = arr.length;
            } else {
                nextMax[currentIndex] = st.peek();
            }

            st.push(currentIndex);
            currentIndex--;
        }
    }

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int prevMin[] = new int[arr.length];
        int nextMin[] = new int[arr.length];
        int prevMax[] = new int[arr.length];
        int nextMax[] = new int[arr.length];
        findPrevMin(arr, prevMin);
        printArray(prevMin);
        findNextMin(arr, nextMin);
        findNextMax(arr, nextMax);
        findPrevMax(arr, prevMax);
        int totalMin = 0;
        int totalMax = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            totalMin = totalMin + (i - prevMin[i]) * (nextMin[i] - i) * currentElement;
            totalMax = totalMax + (i - prevMax[i]) * (nextMax[i] - i) * currentElement;

        }
        System.out.println(totalMax);
        System.out.println(totalMin);
        int total = totalMax - totalMin;

        System.out.println(total);

    }

}
