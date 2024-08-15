package array;

public class maxSumKedane {

    public static int getMaxValue(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax = currentMax + arr[i];
            if (currentMax > maxValue) {
                maxValue = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        // int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // int arr[] = { 1 };
        int arr[] = { 5, 4, -1, 7, 8 };
        System.out.println(getMaxValue(arr));
    }

}
