package Sheet.Array.Easy;

public class findMaxAndMin {

    public static int[] findMinMax(int arr[]) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        int resultArray[] = new int[2];
        resultArray[0] = minValue;
        resultArray[1] = maxValue;
        System.out.println(minValue + " " + maxValue);

        return resultArray;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 4, 1, 9 };
        System.out.println(findMinMax(arr));

    }

}
