package SlidingWindowGFG.Medium;

public class productLessThanK {

    public static long findTotalElement(int arr[], long k) {

        int left = 0;
        long totalCount = 0;
        long currentMul = 1;
        for (int i = 0; i < arr.length; i++) {
            currentMul = (long) (currentMul * arr[i]);
            while (currentMul >= k) {
                currentMul = (long) (currentMul / arr[left]);
                left++;
            }
            totalCount = totalCount + i - left + 1;
        }
        System.out.println();
        return totalCount;

    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4 };
        long k = 10;
        System.out.println(findTotalElement(a, k));

    }

}
