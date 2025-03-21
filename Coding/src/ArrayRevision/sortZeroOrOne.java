package ArrayRevision;

public class sortZeroOrOne {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 1 };
        int prev = -1;
        int curr = 0;
        int last = arr.length - 1;
        while (curr <= last) {
            while (last > 0 && arr[last] == 2) {
                last--;
            }
            while (curr <= last && arr[curr] == 0) {
                prev++;
                int temp = arr[prev];
                arr[prev] = arr[curr];
                arr[curr] = temp;
                curr++;

            }
            if (curr < last && arr[curr] == 2) {
                int temp = arr[curr];
                arr[curr] = arr[last];
                arr[last] = temp;
                last--;
            }
            if (curr <= last && arr[curr] == 1) {
                curr++;
            }
        }
        printArray(arr);
    }

}
