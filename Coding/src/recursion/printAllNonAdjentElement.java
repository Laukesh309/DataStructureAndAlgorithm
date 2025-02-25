package recursion;

public class printAllNonAdjentElement {

    public static void printAllSubSequence(int arr[], int currentIndex, String result) {
        if (currentIndex > arr.length - 1) {
            System.out.println(result);
            return;
        }
        printAllSubSequence(arr, currentIndex + 2, result + arr[currentIndex]);
        printAllSubSequence(arr, currentIndex + 1, result);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        printAllSubSequence(arr, 0, "");

    }

}
