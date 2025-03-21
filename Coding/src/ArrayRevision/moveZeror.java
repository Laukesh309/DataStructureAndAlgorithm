package ArrayRevision;

public class moveZeror {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };
        int prev = -1;
        int current = 0;
        while (current < arr.length) {
            if (arr[current] != 0) {
                prev++;
                int temp = arr[current];
                arr[current] = arr[prev];
                arr[prev] = temp;
            }
        }
    }

}
