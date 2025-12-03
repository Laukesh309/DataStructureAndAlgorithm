package GraphCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MiinimumMultiplicationToReachDest {

    static class Pair {
        int source;
        int level;

        Pair(int source, int level) {
            this.source = source;
            this.level = level;
        }
    }

    public static int findMinMultiPlication(int arr[], int start, int end) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(start, 0));
        boolean[] visited = new boolean[100000];
        Arrays.fill(visited, false);
        visited[start] = true;
        while (!que.isEmpty()) {
            Pair pq = que.poll();
            int source = pq.source;
            int level = pq.level;
            for (int i = 0; i < arr.length; i++) {
                int curSource = (source * arr[i]) % 100000;
                if (curSource == end) {
                    return level + 1;
                }
                if (!visited[curSource]) {
                    que.add(new Pair(curSource, level + 1));
                    visited[curSource] = true;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 65 };
        int start = 7, end = 66175;
        System.out.println(findMinMultiPlication(arr, start, end));
    }

}
