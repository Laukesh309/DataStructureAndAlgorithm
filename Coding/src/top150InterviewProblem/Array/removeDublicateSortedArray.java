package top150InterviewProblem.Array;

public class removeDublicateSortedArray {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int removeDublicateArray(int arr[]) {
        int prev = 0;
        int start = 1;
        int counter = 1;
        int result = 1;
        while (start < arr.length) {
            if (arr[prev] == arr[start] && counter < 2) {
                prev++;
                int temp = arr[start];
                arr[start] = arr[prev];
                arr[prev] = temp;
                counter++;
                start++;
                result++;

            } else if (arr[prev] == arr[start] && counter >= 2) {
                start++;
            } else {
                prev++;
                counter = 1;
                int temp = arr[start];
                arr[start] = arr[prev];
                arr[prev] = temp;
                start++;
                result++;
            }

        }
        // System.out.println(result);
        // printArray(arr);
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        removeDublicateArray(nums);

    }

}
