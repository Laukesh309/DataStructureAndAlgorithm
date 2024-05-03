package Stack;

import java.util.Stack;

public class maxAreaHistogram {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findRighSmallestElement(int height[], int result[]) {

        Stack<Integer> stk = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!stk.empty() && height[i] <= height[stk.peek()]) {
                stk.pop();
            }
            if (stk.empty()) {
                result[i] = -1;
            } else {
                result[i] = stk.peek();
            }
            stk.push(i);
        }
        printArray(result);

    }

    public static void findLeftSmallestIndex(int height[], int result[]) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stk.empty() && height[i] <= height[stk.peek()]) {
                stk.pop();
            }
            if (stk.empty()) {
                result[i] = -1;
            } else {
                result[i] = stk.peek();
            }
            stk.push(i);
        }
        printArray(result);
    }

    public static void findMaxArea(int height[]) {
        int result1[] = new int[height.length];
        int result2[] = new int[height.length];
        int result[] = new int[height.length];
        findLeftSmallestIndex(height, result1);
        findRighSmallestElement(height, result2);
        for (int i = 0; i < height.length; i++) {
            int currentHeight = height[i];
            int currentWidth = (result2[i] == -1 ? height.length : result2[i]) - result1[i] - 1;
            result[i] = currentHeight * currentWidth;
        }
        printArray(result);
    }

    public static void main(String[] args) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        findMaxArea(height);
    }

}
