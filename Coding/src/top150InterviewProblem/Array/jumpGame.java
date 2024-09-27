package top150InterviewProblem.Array;

public class jumpGame {

    public static boolean findReach(int num[], int currentIndex) {
        if (currentIndex >= num.length) {
            return false;
        }
        if (currentIndex == num.length - 1) {
            return true;
        }
        int currentValue = num[currentIndex];
        for (int i = 1; i <= currentValue; i++) {
            if (findReach(num, currentIndex + i)) {
                return true;
            }
        }
        return false;
    }

    public static void printArray(boolean dp[]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static boolean findReachDynamic(int num[]) {
        boolean dp[] = new boolean[num.length];
        dp[num.length - 1] = true;
        for (int i = num.length - 2; i >= 0; i--) {
            int currentValue = num[i];
            boolean result = false;
            for (int j = 1; j <= currentValue; j++) {
                if ((i + j) < num.length) {
                    result = dp[i + j] || result;
                }
                if (result == true) {
                    break;
                }
            }
            dp[i] = result;
        }
        printArray(dp);
        return dp[0];
    }

    public static boolean findReach(int num[]) {
        int reachable = 0;
        for (int i = 0; i < num.length; i++) {
            if (i > reachable) {
                return false;
            }
            if (reachable >= num.length - 1) {
                return true;
            }
            reachable = Math.max(i + num[i], reachable);
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 5, 0, 0 };
        // System.out.println(findReach(nums, 0));
        // findReachDynamic(nums);
        System.out.println(findReach(nums));
    }

}
