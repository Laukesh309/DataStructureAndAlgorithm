package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseScheduleTwo {

    public static void findCouseTopo(ArrayList<ArrayList<Integer>> adj, int inOrder[]) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == 0) {
                que.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int source = que.poll();
            result.add(source);
            for (int i = 0; i < adj.get(source).size(); i++) {
                int dest = adj.get(source).get(i);
                inOrder[dest]--;
                if (inOrder[dest] == 0) {
                    que.add(dest);
                }
            }
        }
        if (result.size() < inOrder.length) {
            return new int[];
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int inOrder[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][0];
            int dest = prerequisites[i][1];
            inOrder[source]++;
            adj.get(dest).add(source);
        }
        findCouseTopo(adj, inOrder);
    }

}
