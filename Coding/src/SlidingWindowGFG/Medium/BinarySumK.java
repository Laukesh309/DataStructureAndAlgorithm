package SlidingWindowGFG.Medium;

public class BinarySumK {

    public static int findTotalSubArray(int arr[], int target) {
        int left = 0;
        int right = 0;
        int total = 0;
        int currentSum = 0;
        while (right < arr.length) {
            currentSum = currentSum + arr[right];
            while (currentSum >= target) {
                currentSum = currentSum - arr[left];
                left++;
            }
            total = total + right - left + 1;
            right++;
        }
        return total;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 1 };
        int target = 2;
        int left = findTotalSubArray(arr, target);
        int right = findTotalSubArray(arr, target + 1);
        System.out.println(left + " " + right);

    }
}
