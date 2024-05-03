package DynamicProgramming;

public class subSet {

    public static int findSum(int arr[], int currentIndex) {
        int ans = 0;
        for (int i = currentIndex; i < arr.length; i++) {
            ans += arr[currentIndex];
        }
        return ans;
    }

    public static int findAllSubSet(int arr[], int currentIndex, int result) {
        if (currentIndex >= arr.length) {
            return result;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = currentIndex; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[currentIndex];
            arr[currentIndex] = temp;
            int sum = result + temp;
            int findSum = findSum(arr, currentIndex + 1);
            int difference = Math.abs(findSum - sum);
            int minResult = findAllSubSet(arr, currentIndex + 1, sum);
            arr[currentIndex] = arr[i];
            arr[i] = temp;
            ans = Math.min(Math.min(difference, minResult), ans);

        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };
        System.out.println(findAllSubSet(arr, 0, 0));
    }
}
