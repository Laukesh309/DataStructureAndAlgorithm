package StackRevision;

import java.util.Stack;

public class astroidCollision1 {

    public static void findAstroid(int asteroids[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int curElement = asteroids[i];
            while (!st.isEmpty() && ((st.peek() > 0 && curElement < 0))) {
                if (Math.abs(curElement) > Math.abs(st.peek())) {
                    st.pop();
                } else if (Math.abs(curElement) == Math.abs(st.peek())) {
                    curElement = 0;
                    st.pop();
                    break;
                } else {
                    curElement = 0;
                    break;
                }
            }
            if (curElement != 0) {
                st.push(curElement);
            }
        }
        System.out.println(st);
    }

    public static void main(String[] args) {
        int asteroids[] = { 3, 5, -6, 2, -1, 4 };
        findAstroid(asteroids);
    }
}
