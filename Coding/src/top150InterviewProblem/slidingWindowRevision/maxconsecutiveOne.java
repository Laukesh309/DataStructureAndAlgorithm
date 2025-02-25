package top150InterviewProblem.slidingWindowRevision;

public class maxconsecutiveOne {

    public static int findMax(int arr[], int k) {
        int initialPointer = 0;
        int secondPointer = 0;
        int maxLength = 0;
        int counter = 0;
        for (int j = secondPointer; j < arr.length; j++) {
            if (arr[j] == 0) {
                counter++;
            }
            while (counter > k) {
                if (arr[initialPointer++] == 0) {
                    counter--;
                }
            }
            maxLength = Math.max(maxLength, j - initialPointer + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;
        System.out.println(findMax(arr, k));
    }

}
