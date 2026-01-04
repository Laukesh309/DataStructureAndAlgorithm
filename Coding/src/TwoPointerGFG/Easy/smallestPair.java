package TwoPointerGFG.Easy;

public class smallestPair {

    public static int findMaximum(int arr[], int X) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int maxLength = Integer.MAX_VALUE;
        while (right < arr.length) {
            currentSum = currentSum + arr[right];
            while (currentSum > X) {
                maxLength = Math.min(maxLength, right - left + 1);
                currentSum = currentSum - arr[left++];
            }
            right++;
        }
        return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        int x = 100, arr[] = { 1, 10, 5, 2, 7 };
        System.out.println(findMaximum(arr, x));
    }

}
