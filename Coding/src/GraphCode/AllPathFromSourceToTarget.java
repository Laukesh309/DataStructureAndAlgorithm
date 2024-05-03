package GraphCode;

import java.util.ArrayList;
import java.util.Stack;

public class AllPathFromSourceToTarget {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }

    public static void findAllPath(ArrayList<Edge> graph[], int src, int dest, Stack<Integer> stc) {
        stc.push(src);
        if (src == dest) {
            System.out.println(stc);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge edg = graph[src].get(i);
            findAllPath(graph, edg.dest, dest, stc);
            stc.pop();
        }
    }

    public static void main(String[] args) {

        int totalVertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        Stack<Integer> stk = new Stack();
        findAllPath(graph, 5, 1, stk);
    }

}
