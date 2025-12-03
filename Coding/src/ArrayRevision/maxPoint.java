package ArrayRevision;

import java.util.HashMap;

public class maxPoint {

    public static int findMaxPoint(int points[][], int startRow) {
        HashMap<Double, Integer> hm = new HashMap<>();
        int max = 0;

        for (int i = startRow + 1; i < points.length; i++) {
            double slope;
            int dy = points[i][1] - points[startRow][1];
            int dx = points[i][0] - points[startRow][0];
            if (dx == 0) {
                slope = Double.POSITIVE_INFINITY;
            } else {
                slope = (double) dy / dx;
            }

            hm.put(slope, hm.getOrDefault(slope, 0) + 1);
            System.out.println(hm);
            max = Math.max(max, hm.get(slope));
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int points[][] = { { 2, 3 }, { 3, 3 }, { -5, 3 } };
        int overAllMax = 0;
        for (int i = 0; i < points.length; i++) {
            System.out.println(findMaxPoint(points, i));
            overAllMax = Math.max(overAllMax, findMaxPoint(points, i));

        }
        System.out.println(overAllMax);

    }

}
