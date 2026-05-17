package GfGGraph.LeetcodeGraphRevision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class EvaluateDivision {

    static class Pair {
        String dest;
        double weight;

        Pair(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void printArray(double result[]) {
        for (double d : result) {
            System.out.println(d);
        }
    }

    public static double findPath(HashMap<String, List<Pair>> hm, String currentString, Stack<String> path,
            double value, String destination) {

        if (path.contains(currentString)) {
            return -1.00000;
        }
        if (currentString.equals(destination)) {
            return value;
        }
        path.add(currentString);
        System.out.println(currentString);
        List<Pair> list = hm.get(currentString);
        for (int i = 0; i < list.size(); i++) {
            String dest = list.get(i).dest;
            double weight = list.get(i).weight;
            double result = findPath(hm, dest, path, value * weight, destination);
            if (result != -1.00000) {
                path.pop();
                return result;
            }
        }
        path.pop();
        return -1.00000;

    }

    public static void findEquation(List<List<String>> equations, double values[], List<List<String>> queries) {
        HashMap<String, List<Pair>> hm = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> tempString = equations.get(i);
            String src = tempString.get(0);
            String dest = tempString.get(1);
            double weight = values[i];
            if (hm.containsKey(src)) {
                hm.get(src).add(new Pair(dest, weight));
            } else {
                hm.put(src, new ArrayList<>());
                hm.get(src).add(new Pair(dest, weight));
            }
            if (hm.containsKey(dest)) {
                hm.get(dest).add(new Pair(src, 1 / weight));
            } else {
                hm.put(dest, new ArrayList<>());
                hm.get(dest).add(new Pair(src, 1 / weight));
            }
        }
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String currentString = queries.get(i).get(0);
            String destination = queries.get(i).get(1);
            Stack<String> path = new Stack<>();

            if (hm.containsKey(currentString)) {
                double finalResult = findPath(hm, currentString, path, 1, destination);
                result[i] = finalResult;
            } else {
                result[i] = -1.00000;
            }

        }
        printArray(result);

    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        double values[] = { 2.0, 3.0 };
        List<List<String>> queries = new ArrayList();
        String[][] temp = { { "a", "b" }, { "b", "c" } };
        String[][] query = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
        for (int i = 0; i < temp.length; i++) {
            List<String> temp1 = new ArrayList<>();
            String ch1 = temp[i][0];
            String ch2 = temp[i][1];
            temp1.add(ch1);
            temp1.add(ch2);
            equations.add(temp1);
        }
        findEquation(equations, values, queries);
        for (int i = 0; i < query.length; i++) {
            String ch1 = query[i][0];
            String ch2 = query[i][1];
            List<String> temp2 = new ArrayList<>();
            temp2.add(ch1);
            temp2.add(ch2);
            queries.add(temp2);
        }
        findEquation(equations, values, queries);

    }
}
