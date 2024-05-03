package DynamicProgramming;

public class findSubSetRecursion {
    static int counter = 0;

    public static void totalSubSet(int arr[], int currentIndex, String result) {

        if (currentIndex >= arr.length) {
            counter++;
            System.out.println(result);
            return;
        }
        totalSubSet(arr, currentIndex + 1, result + arr[currentIndex]);
        totalSubSet(arr, currentIndex + 1, result);
    }

    public static void main(String[] args) {
        int number[] = { 2, 5, 1 };
        totalSubSet(number, 0, "");
        System.out.println(counter);
    }

}
