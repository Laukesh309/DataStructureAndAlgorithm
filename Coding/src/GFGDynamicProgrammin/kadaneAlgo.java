package GFGDynamicProgrammin;

public class kadaneAlgo {

    public static int findMaxLength(int arr[]) {
        int maxValue = Integer.MIN_VALUE;
        int currentValue = 0;
        for (int i = 0; i < arr.length; i++) {
            currentValue = Math.max(currentValue + arr[i], arr[i]);
            maxValue = Math.max(maxValue, currentValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, -8, 7, -1, 2, 3 };
        System.out.println(findMaxLength(arr));
    }

}
