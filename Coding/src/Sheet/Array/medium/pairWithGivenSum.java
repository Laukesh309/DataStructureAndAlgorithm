package Sheet.Array.medium;

// https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class pairWithGivenSum {

    public static int findNoOfPair(int arr[], int k) {
        int totalPair = 0;
        int startPointer = 0;
        int endPointer = arr.length - 1;
        while (startPointer < endPointer) {
            int value = arr[startPointer] + arr[endPointer];
            if (value == k) {
                totalPair++;
                startPointer++;
                endPointer--;
            } else if (value > k) {
                endPointer--;
            } else {
                startPointer++;
            }
        }
        return totalPair;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 98;
        System.out.println(findNoOfPair(arr, k));
    }

}
