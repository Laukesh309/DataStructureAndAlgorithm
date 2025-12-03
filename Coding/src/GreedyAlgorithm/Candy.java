package GreedyAlgorithm;

public class Candy {

    public static int findTotalSum(int item[]) {
        int i = 1;
        int totalSum = 1;
        while (i < item.length) {
            int peak = 1;
            if (i < item.length && item[i] == item[i - 1]) {
                totalSum = totalSum + 1;
                i++;
            }
            while (i < item.length && item[i] > item[i - 1]) {
                peak++;
                totalSum = totalSum + peak;
                i++;
            }
            int down = 0;
            while (i < item.length && item[i] < item[i - 1]) {
                down++;
                totalSum = totalSum + down;
                i++;
            }
            totalSum = totalSum - peak + Math.max(peak, down + 1);

        }
        System.out.println(totalSum);
        return totalSum;
    }

    public static void main(String[] args) {
        int item[] = { 1, 0, 2 };
        findTotalSum(item);

    }

}
