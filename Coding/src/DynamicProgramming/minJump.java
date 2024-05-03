package DynamicProgramming;

public class minJump {

    public static int findMinimumStep(int jump[], int currentIndex, int result, String strResult) {
        if (currentIndex == jump.length - 1) {
            System.out.println(strResult);
            return result;
        }
        if (currentIndex >= jump.length) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= jump[currentIndex]; i++) {
            ans = Math.min(ans, findMinimumStep(jump, currentIndex + i, result + 1, strResult + (currentIndex + i)));
        }
        return ans;
    }

    public static int findMinimumStepTabulisation(int jump[]) {
        int dp[] = new int[jump.length];
        dp[jump.length - 1] = 0;

        for (int i = jump.length - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            int noJump = jump[i];
            for (int j = 1; j <= noJump; j++) {
                if (i + j < jump.length) {
                    ans = Math.min(ans, 1 + dp[i + j]);
                }
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int jump[] = { 2, 3, 1, 1, 4 };
        System.out.println(findMinimumStep(jump, 0, 0, ""));
        System.out.println(findMinimumStepTabulisation(jump));

    }

}
