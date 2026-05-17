package GfGGraph.LeetcodeGraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import top150InterviewProblem.Array.intergerToRoman;

public class courseScheduleSecond {

    public static int[] scheduleCourse(int numCourses, int prerequisites[][]) {
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        int inOrder[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int dest = prerequisites[i][0];
            inOrder[dest]++;
            edge.get(source).add(dest);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inOrder[i] == 0) {
                que.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int source = que.poll();
            result.add(source);
            for (int i = 0; i < edge.get(source).size(); i++) {
                int dest = edge.get(source).get(i);
                inOrder[dest]--;
                if (inOrder[dest] == 0) {
                    que.add(dest);
                }
            }
        }
        if (result.size() != numCourses) {
            return new int[0];
        }
        int finalResult[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int numCourses = 4, prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(scheduleCourse(numCourses, prerequisites));
    }

}
