package GraphRevision;

import java.util.ArrayList;

public class cycleDetectionDirectedGraph {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], int currentIndex, ArrayList<Integer> result,
            boolean visited[]) {
        visited[currentIndex] = true;
        result.add(currentIndex);
        for (int i = 0; i < graph[currentIndex].size(); i++) {
            Edge edge = graph[currentIndex].get(i);
            int currDes = edge.dest;
            if (result.contains(currDes)) {
                System.out.println(result);
                return true;
            }
            if (!visited[currDes]) {
                if (detectCycleUtil(graph, currDes, result, visited)) {
                    return true;
                }
            }
        }
        result.remove(result.size() - 1);
        return false;

    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, i, result, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
