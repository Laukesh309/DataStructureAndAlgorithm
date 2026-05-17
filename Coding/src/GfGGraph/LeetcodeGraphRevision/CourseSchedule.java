package GfGGraph.LeetcodeGraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static boolean sheduleCourse(int preRequisites[][], int numCourses) {
        int inDegree[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < preRequisites.length; i++) {
            int dest = preRequisites[i][0];
            int source = preRequisites[i][1];
            inDegree[dest]++;
            edge.get(source).add(dest);
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }
        int totalCourse = 0;
        while (!que.isEmpty()) {
            int source = que.poll();
            totalCourse++;
            for (int i = 0; i < edge.get(source).size(); i++) {
                int neighbour = edge.get(source).get(i);
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    que.add(neighbour);
                }
            }

        }

        return totalCourse == numCourses;
    }

    public static void main(String[] args) {

        int prerequisites[][] = { { 1, 0 } };
        sheduleCourse(prerequisites, 2);

    }

}
