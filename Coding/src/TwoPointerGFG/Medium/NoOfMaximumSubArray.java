package TwoPointerGFG.Medium;

public class NoOfMaximumSubArray {

    public static int findTotal(int a[], int L) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int totalCount = 0;
        while (right < a.length) {
            System.out.println("testing");
            while (right < a.length && sum + a[right] < L) {
                System.out.println("this is aluekh");
                right++;
                totalCount++;
            }
            while (sum >= L) {
                sum = sum - a[left];
                left++;
            }
            if (left > right) {
                right = left;
            } else {
                totalCount++;
                right++;
            }
        }
        System.out.println(totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        int a[] = { 2, 0, 11, 3, 0 };
        int L = 1;
        int R = 10;
        int left = findTotal(a, L);
        int right = findTotal(a, R + 1);
        System.out.println(left + " " + right);
    }
}
