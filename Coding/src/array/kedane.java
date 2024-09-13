package array;

public class kedane {

    public static int maxSum(int arr[]) {

        int max = Integer.MAX_VALUE;
        int currentValue = 0;

        for (int i = 0; i < arr.length; i++) {
            currentValue += arr[i];
            max = Math.max(currentValue, max);
            if (currentValue < 0) {
                {
                    currentValue = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, -2, -6 };
    }

}
