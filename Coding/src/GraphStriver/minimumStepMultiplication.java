package GraphStriver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class minimumStepMultiplication {

    static class Pair {
        int source;
        int step;

        Pair(int source, int step) {
            this.source = source;
            this.step = step;
        }
    }

    public static int findMinStep(int arr[], int start, int end) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(start, 0));
        int visited[] = new int[100000];

        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[0] = 0;
        while (!que.isEmpty()) {
            Pair currPair = que.remove();
            int currentdest = currPair.source;
            int currStep = currPair.step;
            if (currentdest == end) {
                return currStep;
            }
            for (int i = 0; i < arr.length; i++) {
                int dest = (arr[i] * currentdest) % 100000;
                if (currStep + 1 < visited[dest]) {
                    visited[dest] = currStep + 1;
                    que.add(new Pair(dest, currStep + 1));
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 65 };
        int start = 7, end = 66175;
        System.out.println(findMinStep(arr, start, end));
    }

}
