package DynamicProgramming;

public class zerooneknapsackSubSetProblem {

    public static void findSubSet(int value[], int weight[], int currentIndex, int totalWeight, String result) {
        if (totalWeight == 0) {
            System.out.println(result);
            return;
        }
        if (currentIndex >= weight.length || totalWeight < 0) {
            return;
        }
        if (totalWeight < weight[currentIndex]) {
            findSubSet(value, weight, currentIndex + 1, totalWeight, result);
        } else {
            findSubSet(value, weight, currentIndex + 1, totalWeight - weight[currentIndex],
                    weight[currentIndex] + result);
            findSubSet(value, weight, currentIndex + 1, totalWeight, result);

        }
    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weight[] = { 2, 5, 1, 3, 4 };
        int totalSum = 7;
        findSubSet(value, weight, 0, totalSum, "");
    }

}
