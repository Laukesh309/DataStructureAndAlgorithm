package ArrayRevision.medium;

// https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0?category&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-in-sub-arrays

public class maximunSubArrayMin {

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 1, 6 };
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            result = Math.max(arr[i] + arr[i + 1], result);
        }
        System.out.println(result);
    }
}