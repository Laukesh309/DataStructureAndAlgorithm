package GraphStriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class couseShedule {

    public static void createGraph(List<List<Integer>> graph, int[][] prerequisites, int V) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int dest = prerequisites[i][0];
            graph.get(source).add(dest);
        }

    }

    public static void sheduleCourse(List<List<Integer>> graph, int V) {
        int inDegree[] = new int[V];
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int dest = graph.get(i).get(j);
                inDegree[dest]++;
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int current = que.remove();
            result.add(current);
            for (int i = 0; i < graph.get(current).size(); i++) {
                int dest = graph.get(current).get(i);
                inDegree[dest]--;
                if (inDegree[dest] == 0) {
                    que.add(dest);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 2;
        int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        List<List<Integer>> graph = new ArrayList<>();
        createGraph(graph, prerequisites, N);

    }

}
