package DynamicProgramming;

public class mountainRanges {

    public static int findTotalMountainFormed(int number) {
        int dp[] = new int[number + 1];
        dp[0] = 1;
        dp[1] = 1;
        int currentNumber = 2;
        while (currentNumber <= number) {
            int result = 0;
            for (int i = 0; i < currentNumber; i++) {
                result += dp[i] * dp[currentNumber - i - 1];
            }
            dp[currentNumber++] = result;

        }
        return dp[number];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(findTotalMountainFormed(n));
    }

}
