package Sheet.Array.medium;

public class suffixMax {
    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int[] getMaxSuffix(int arr[]) {
        int suffixResult[] = new int[arr.length];
        int suffixMax = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (suffixMax <= arr[i]) {
                suffixMax = arr[i];
            }
            suffixResult[i] = suffixMax;
        }
        return suffixResult;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 0, 3, 2, 5 };
        printArray(getMaxSuffix(arr));
    }

}
