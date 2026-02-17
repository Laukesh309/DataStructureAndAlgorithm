package GFGDynamicProgrammin;

public class matrixChainMultplication {

    public static int findResult(int arr[], int startIndex, int endIndex) {
        if (startIndex + 1 == endIndex) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = startIndex + 1; k < endIndex; k++) {
            int prevMultiplication = findResult(arr, startIndex, k);
            int nextMultiplication = findResult(arr, k, endIndex);
            int total = prevMultiplication + nextMultiplication + arr[startIndex] * arr[k] * arr[endIndex];
            ans = Math.min(ans, total);
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = { 2, 1, 3, 4 };
        System.out.println(findResult(arr, 0, arr.length - 1));
    }
}
