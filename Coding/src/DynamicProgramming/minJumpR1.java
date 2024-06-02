package DynamicProgramming;

public class minJumpR1 {

    public static int findMinJump(int jump[], int currentIndex, int result, String resultStr) {
        if (currentIndex == jump.length - 1) {
            System.out.println(result + " " + currentIndex + " " + resultStr);
            return result;
        }
        if (currentIndex >= jump.length) {
            return Integer.MAX_VALUE;
        }
        int currentValue = jump[currentIndex];
        int currentResult = Integer.MAX_VALUE;
        for (int i = 1; i <= currentValue; i++) {
            int totalJump = findMinJump(jump, currentIndex + i, result + 1, resultStr + currentIndex);
            currentResult = Math.min(currentResult, totalJump);
        }
        return currentResult;

    }

    public static int findMinJumpTabulisation(int jump[]) {
        int dp[] = new int[jump.length];
        dp[jump.length - 1] = 0;
        for (int i = jump.length - 2; i >= 0; i--) {
            int currentValue = jump[i];
            int result = Integer.MAX_VALUE;
            for (int j = 1; j <= currentValue; j++) {
                if (i + j <= jump.length - 1) {
                    if (dp[i + j] != -1) {
                        result = Math.min(result, 1 + dp[i + j]);
                    }

                }
            }
            if (result == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = result;
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        int jump[] = { 2, 3, 1, 1, 4 };
        System.out.println(findMinJump(jump, 0, 0, ""));
        System.out.println(findMinJumpTabulisation(jump));
    }

}
