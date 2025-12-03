package GraphCode;

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

    public static double findValue(HashMap<String, List<Pair>> hm, String source, double currentWeight, String target,
            Stack<String> path) {
        if (source.equals(target)) {
            return currentWeight;
        }
        if (!hm.containsKey(source)) {
            return -1.00000;
        }
        for (int i = 0; i < hm.get(source).size(); i++) {
            String dest = hm.get(source).get(i).dest;
            double weight = hm.get(source).get(i).weight;
            if (!path.contains(dest)) {
                path.add(dest);
                double tempWeight = findValue(hm, dest, currentWeight * weight, target, path);
                if (tempWeight != -1.00000) {
                    return tempWeight;
                }
            }

        }
        return -1.00000;
    }

    public static void findDivision(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> hm = new HashMap<>();
        System.out.println(equations);
        for (int i = 0; i < equations.size(); i++) {
            String source = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            System.out.println("source " + source);
            System.out.println("dest " + dest);
            List<Pair> tempSourceList = hm.getOrDefault(source, new ArrayList<Pair>());
            tempSourceList.add(new Pair(dest, values[i]));
            List<Pair> tempDestinationList = hm.getOrDefault(dest, new ArrayList<Pair>());
            tempDestinationList.add(new Pair(source, 1 / values[i]));
            hm.put(source, tempSourceList);
            hm.put(dest, tempDestinationList);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            Stack<String> path = new Stack<>();
            if (hm.containsKey(source) && hm.containsKey(dest)) {
                path.add(source);
                result[i] = findValue(hm, source, 1, dest, path);
            } else {
                result[i] = -1.00000;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        String temp[][] = { { "a", "b" }, { "b", "c" } };
        String tempQuery[][] = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
        double values[] = { 2.0, 3.0 };
        for (int i = 0; i < temp.length; i++) {
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(temp[i][0]);
            tempList.add(temp[i][1]);
            equations.add(tempList);
        }
        for (int i = 0; i < tempQuery.length; i++) {
            ArrayList<String> tempquery = new ArrayList<>();
            tempquery.add(tempQuery[i][0]);
            tempquery.add(tempQuery[i][1]);
            queries.add(tempquery);
        }
        // System.out.println(queries);
        findDivision(equations, values, queries);
    }

}
