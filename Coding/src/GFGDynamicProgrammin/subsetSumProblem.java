package GFGDynamicProgrammin;

public class subsetSumProblem {

    public static boolean findSubSet(int arr[], int currentIndex, int sum) {
        if (currentIndex < 0) {
            return false;
        }
        if (sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        int currentElement = arr[currentIndex];
        boolean include = false;
        boolean exclude = findSubSet(arr, currentIndex - 1, sum);
        if (currentElement <= sum) {
            include = findSubSet(arr, currentIndex - 1, sum - currentElement);
        }
        return include || exclude;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        for (int row = 0; row <= arr.length; row++) {
            dp[row][0] = true;
        }
        for (int row = 1; row <= arr.length; row++) {
            for (int col = 1; col < sum + 1; col++) {
                int currentElement = arr[row - 1];
                dp[row][col] = dp[row - 1][col];
                if (currentElement <= col) {
                    dp[row][col] = dp[row][col] || dp[row - 1][col - currentElement];
                }
            }
        }
        // System.out.println(dp[arr.length][sum]);
        System.out.println(findSubSet(arr, arr.length - 1, sum));
    }

}
