package TwoPointerGFG.Medium;

public class totalSubArray {

    public static int findMaxSubArray(int a[], int L, int R) {
        int lastValid = -1;
        int lastInvalid = -1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > R) {
                lastInvalid = i;
                lastValid = -1;
            }
            if (a[i] >= L && a[i] <= R) {
                lastValid = i;
            }
            if (lastValid != -1) {
                count = count + lastValid - lastInvalid;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = { 3, 4, 1 };
        int L = 2;
        int R = 4;
        int result = findMaxSubArray(a, L, R);
        System.out.println(result);

    }

}
