package array;

public class maxofthreesequence {

    public static int getMax(int arr[]) {
        int i = 0;
        int j = 1;
        int max = arr[0];
        while (j < 3) {
            max = max + arr[j++];
        }
        int currentSum = max;
        while (j < arr.length) {
            currentSum = arr[j++] + currentSum - arr[i++];
            max = Math.max(max, currentSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 8, 3, 1 };
        System.out.println(getMax(arr));
    }

}
