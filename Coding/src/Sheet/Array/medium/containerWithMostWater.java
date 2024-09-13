package Sheet.Array.medium;

// https://leetcode.com/problems/container-with-most-water/description/

public class containerWithMostWater {

    public static int findMaxWater(int arr[]) {
        int start = 0;
        int last = arr.length - 1;
        int result = Integer.MIN_VALUE;
        while (start < last) {
            int height = Math.min(arr[start], arr[last]);
            int area = height * (last - start);
            result = Math.max(result, area);
            if (arr[start] <= arr[last]) {
                start++;
            } else {
                last--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1 };
        System.out.println(findMaxWater(arr));

    }

}
