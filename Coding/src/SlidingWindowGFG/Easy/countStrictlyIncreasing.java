package SlidingWindowGFG.Easy;

public class countStrictlyIncreasing {

    public static int findMaxArray(int arr[]) {
        int left = 0;
        int right = 1;
        int maxLength = 0;
        while (right < arr.length) {
            while (right < arr.length && arr[right] > arr[right - 1]) {
                right++;
            }
            int n = right - left - 1;
            maxLength = maxLength + n * (n + 1) / 2;
            left = right;
            right++;
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 3, 7, 9 };
        System.out.println(findMaxArray(arr));
    }

}
