package GraphCode;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void findTopologicalSortUtil(ArrayList<Edge> graph[], int currentIndex, Stack<Integer> st) {
        if (st.contains(currentIndex)) {
            return;
        }
        for (int i = 0; i < graph[currentIndex].size(); i++) {
            Edge edge = graph[currentIndex].get(i);
            findTopologicalSortUtil(graph, edge.dest, st);
        }
        st.add(currentIndex);

    }

    public static void findTopologicalSort(ArrayList<Edge> graph[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!st.contains(i)) {
                findTopologicalSortUtil(graph, i, st);
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int vertes = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertes];
        createGraph(graph);
        findTopologicalSort(graph);

    }

}
