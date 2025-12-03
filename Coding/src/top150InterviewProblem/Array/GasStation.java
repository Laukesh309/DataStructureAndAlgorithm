package top150InterviewProblem.Array;

public class GasStation {

    public static boolean isPathExist(int i, int gas[], int cast[]) {
        int initialIndex = i;
        if (gas[i] < cast[i]) {
            return false;
        }
        int currentGas = gas[initialIndex] - cast[initialIndex];
        initialIndex = initialIndex + 1;
        initialIndex = initialIndex % gas.length;
        while (initialIndex != i) {
            System.out.println(initialIndex);
            currentGas = currentGas + gas[initialIndex] - cast[initialIndex];
            if (currentGas < 0) {
                return false;
            }
            initialIndex++;
            initialIndex = initialIndex % gas.length;

        }
        return true;
    }

    public static void main(String[] args) {
        int gas[] = { 1, 2, 3, 4, 5 }, cost[] = { 3, 4, 5, 1, 2 };
        int diff = 0;
        int result = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            diff = diff + gas[i] - cost[i];
            result = result + gas[i] - cost[i];
            if (result < 0) {
                result = 0;
                index = i + 1;
            }

        }
        if (diff < 0 || index >= gas.length) {
            System.out.println("-1");
            return;
        }
        System.out.println(index);

    }

}
