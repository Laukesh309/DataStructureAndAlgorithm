package GreedyAlgorithm;

public class jumpGame2 {

    public static int findMinJump(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 0;
        }
        int prev = arr.length - 2;
        while (prev >= 0) {
            int currentStep = arr[prev];
            int minValue = currentStep == 0 ? Integer.MAX_VALUE - 3 : Integer.MAX_VALUE;
            for (int i = 1; i <= currentStep; i++) {
                if (i + prev >= arr.length - 1) {
                    minValue = 1;
                } else {
                    minValue = Math.min(minValue, 1 + dp[i + prev]);
                }
            }
            dp[prev] = minValue;
            System.out.println(minValue);
            prev--;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int num[] = { 2, 3, 0, 1, 4 };
        System.out.println(findMinJump(num));

    }

}
