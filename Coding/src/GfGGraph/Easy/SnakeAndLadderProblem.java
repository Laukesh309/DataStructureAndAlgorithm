package GfGGraph.Easy;

import java.util.HashMap;

public class SnakeAndLadderProblem {

    public static int findMinCoin(int currentNo, HashMap<Integer, Integer> hm, int visited[]) {
        if (currentNo > 30) {
            return Integer.MAX_VALUE;
        }
        if (currentNo == 30) {
            return 0;
        }

        int totalPath = Integer.MIN_VALUE;
        for (int i = 1; i <= 6; i++) {
            int nextMove = currentNo + i;
            if (hm.containsKey(nextMove)) {
                if(visited[hm.get(nextMove)]>)

            }
            int findNextPath = findMinCoin(currentNo, hm, visited);
            if (findNextPath != Integer.MAX_VALUE) {
                totalPath = Math.min(totalPath, 1 + findNextPath);
            }
        }
        return totalPath;

    }

    public static void main(String[] args) {
        int N = 8;
        int visited[] = new int[31];
        for (int i = 0; i < 31; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        int arr[] = { 3, 22, 5, 8, 11, 26, 20, 29,
                17, 4, 19, 7, 27, 1, 21, 9 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int source = arr[2 * i];
            int dest = arr[2 * i + 1];
            hm.put(source, dest);
        }
        System.out.println(hm);
    }

}
