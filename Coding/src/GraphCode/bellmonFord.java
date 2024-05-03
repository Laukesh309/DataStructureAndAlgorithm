package GraphCode;

import java.util.ArrayList;

public class bellmonFord {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    public static void bellmonford(ArrayList<Edge> graph[], int src) {
        int totalVertex = graph.length;
        int distance[] = new int[totalVertex];
        for (int i = 0; i < distance.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < totalVertex - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge edge = graph[j].get(k);
                    int u = edge.src;
                    int v = edge.dest;
                    int weight = edge.weight;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                    }

                }
            }

        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    public static void main(String[] args) {
        int totalVertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        bellmonford(graph, 0);

    }

}
