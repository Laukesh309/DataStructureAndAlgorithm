package DynamicProgramming;

public class zeroOneKnapSack1 {

    public static int findMaximumProfit(int value[], int weight[], int totalWeight, int currentIndex) {
        if (totalWeight <= 0 || currentIndex >= weight.length) {
            return 0;
        }
        if (weight[currentIndex] <= totalWeight) {
            int includedValue = value[currentIndex]
                    + findMaximumProfit(value, weight, totalWeight - weight[currentIndex], currentIndex + 1);
            int excludedValue = findMaximumProfit(value, weight, totalWeight, currentIndex + 1);
            return Math.max(includedValue, excludedValue);
        }
        return findMaximumProfit(value, weight, totalWeight, currentIndex + 1);
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalWeight = 7;
        System.out.println(findMaximumProfit(value, weight, totalWeight, 0));

    }

}
