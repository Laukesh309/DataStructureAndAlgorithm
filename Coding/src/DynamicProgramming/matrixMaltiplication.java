package DynamicProgramming;

public class matrixMaltiplication {

    public static int findMinMatricsCast(int arr[], int inititlaPointer, int lastPointer) {
        if (inititlaPointer >= lastPointer) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int k = inititlaPointer; k <= lastPointer - 1; k++) {
            int firstValue = findMinMatricsCast(arr, inititlaPointer, k);
            int seconValue = findMinMatricsCast(arr, k + 1, lastPointer);
            int currentValue = arr[inititlaPointer - 1] * arr[k] * arr[lastPointer];
            int combinedValue = firstValue + seconValue + currentValue;
            result = Math.min(result, combinedValue);

        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };

        System.out.println(findMinMatricsCast(arr, 1, arr.length - 1));

    }

}
