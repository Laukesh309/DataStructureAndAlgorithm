package TwoPointerGFG.Medium;

public class tripletSum {

    public static boolean findTripletSum(int arr[], int target) {

        for (int i = 0; i < arr.length; i++) {
            int targetSum = target - arr[i];
            int firstInedx = 0;
            int lastIndex = arr.length - 1;
            while (firstInedx < lastIndex) {
                int currentSum = arr[firstInedx] + arr[lastIndex];
                if (firstInedx == i) {
                    firstInedx++;
                    continue;
                }
                if (lastIndex == i) {
                    lastIndex--;
                    continue;
                }
                if (currentSum == targetSum) {
                    System.out.println(currentSum + " " + i + " " + firstInedx + " " + lastIndex);
                    return true;
                } else if (currentSum > targetSum) {
                    lastIndex--;
                } else {
                    firstInedx++;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 98, 85, 48, 56, 65, 67, 91 };
        int target = 24;
        System.out.println(findTripletSum(arr, target));
    }

}
