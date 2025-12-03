package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detectCycleBFS {

    public static boolean findCycleBFS(ArrayList<ArrayList<Integer>> edge, boolean visited[], int sourceVertex) {
        Queue<Integer> que = new LinkedList<>();
        que.add(sourceVertex);
        visited[sourceVertex] = true;
        while (!que.isEmpty()) {
            int dest = que.poll();
            for (int i = 0; i < edge.get(dest).size(); i++) {
                int curDes = edge.get(dest).get(i);
                System.out.println(curDes);
                if (que.contains(curDes) && visited[curDes]) {
                    return true;
                }
                if (!visited[curDes]) {
                    que.add(curDes);
                    visited[curDes] = true;
                }

            }
        }
        return false;

    }

    public static boolean findCycle(ArrayList<ArrayList<Integer>> edge, int vertex) {
        boolean visited[] = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (!visited[i] && findCycleBFS(edge, visited, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 4 },
                { 1, 2 },
                { 1, 4 },
                { 2, 3 },
                { 3, 4 } };
        int vertex = 5;
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            edge.get(source).add(dest);
            edge.get(dest).add(source);
        }
        System.out.println(edge);
        System.out.println(findCycle(edge, vertex));
    }

}
