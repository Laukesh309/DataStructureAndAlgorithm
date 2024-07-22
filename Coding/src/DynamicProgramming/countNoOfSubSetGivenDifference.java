package DynamicProgramming;

public class countNoOfSubSetGivenDifference {

    public static int findArraySum(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static int totalCount(int arr[], int currentIndex, int result, int totalSum, int differenc, String str) {
        if (currentIndex >= arr.length) {
            if (totalSum - 2 * result == differenc) {
                System.out.println(str);
                return 1;
            } else {
                return 0;
            }
        }
        return totalCount(arr, currentIndex + 1, result + arr[currentIndex], totalSum, differenc,
                str + arr[currentIndex])
                + totalCount(arr, currentIndex + 1, result, totalSum, differenc, str);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3 };
        int sum = findArraySum(arr);
        System.out.println(totalCount(arr, 0, 0, sum, 1, ""));

    }

}
