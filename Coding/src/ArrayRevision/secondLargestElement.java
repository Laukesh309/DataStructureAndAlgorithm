package ArrayRevision;

public class secondLargestElement {

    public static void main(String[] args) {
        int arr[] = { 12, 35, 35, 35, 1, 10, 34, 1 };
        int firstMax = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                firstMax = arr[i];
            }
        }
        int secondMax = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondMax && arr[i] != firstMax) {
                secondMax = arr[i];
            }
        }
        System.out.println(secondMax);
    }

}
