package ArrayRevision;

public class largestElement {

    public static void main(String[] args) {
        int arr[] = { 1, 8, 7, 56, 90 };
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
