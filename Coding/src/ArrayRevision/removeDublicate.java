package ArrayRevision;

public class removeDublicate {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void removeDublicate(int arr[]) {
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[prev]) {
                prev++;
                int temp = arr[prev];
                arr[prev] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(prev + 1);
        printArray(arr);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2 };
        removeDublicate(arr);

    }

}
