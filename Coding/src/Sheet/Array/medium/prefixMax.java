package Sheet.Array.medium;

public class prefixMax {

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int[] getPrifixMax(int arr[]) {
        int prefixMaxArray[] = new int[arr.length];
        int prifixMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > prifixMax) {
                prifixMax = arr[i];
            }
            prefixMaxArray[i] = prifixMax;
        }
        return prefixMaxArray;

    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        printArray(getPrifixMax(arr));
    }

}
