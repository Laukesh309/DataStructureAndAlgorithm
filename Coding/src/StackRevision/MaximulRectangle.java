package StackRevision;

import java.util.Stack;

public class MaximulRectangle {

    public static void findHeight(char matrix[][], int height[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    if (matrix[i][j] == '0') {
                        height[i][j] = 0;
                    } else {
                        height[i][j] = 1;
                    }
                } else if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = 1 + height[i - 1][j];
                }
            }
        }
    }

    public static void printArray(int arr[][]) {
        for (int[] is : arr) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }

    public static void findPrevMin(int height[][], int row, int preMin[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < height[0].length; i++) {
            System.out.println(i);
            int currentElement = height[row][i];

            while (!st.isEmpty() && height[row][st.peek()] >= currentElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                preMin[i] = -1;
            } else {
                preMin[i] = st.peek();
            }
            st.push(i);
        }

    }

    public static void nextMin(int height[][], int row, int nextMin[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = height[0].length - 1; i >= 0; i--) {
            int currentElement = height[row][i];
            while (!st.isEmpty() && height[row][st.peek()] >= currentElement) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextMin[i] = height[0].length;
            } else {
                nextMin[i] = st.peek();
            }
            st.push(i);
        }
    }

    public static void findPrevmax(int height[][]) {
        int total = 0;
        for (int row = 0; row < height.length; row++) {
            int prevMax[] = new int[height[0].length];
            int nextMax[] = new int[height[0].length];
            findPrevMin(height, row, prevMax);
            nextMin(height, row, nextMax);
            for (int i = 0; i < height[0].length; i++) {
                int totalIndex = nextMax[i] - prevMax[i] - 1;
                int area = totalIndex * height[row][i];
                total = Math.max(total, area);
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        char matrix[][] = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        int height[][] = new int[matrix.length][matrix[0].length];
        findHeight(matrix, height);
        printArray(height);
        findPrevmax(height);

    }

}
