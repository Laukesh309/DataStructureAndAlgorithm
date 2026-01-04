package BinarySearchRevision;

public class KthElementSorted {

    public static int findMax(int a[], int b[], int start, int end, int k) {
        int mid = (start + end) / 2;
        int l1 = mid == 0 ? Integer.MIN_VALUE : a[mid - 1];
        int r1 = mid == a.length ? Integer.MAX_VALUE : a[mid];
        int l2 = k - mid == 0 ? Integer.MIN_VALUE : b[k - mid - 1];
        int r2 = k - mid == b.length ? Integer.MAX_VALUE : b[k - mid];
        if (l1 <= r2 && l2 <= r1) {
            return Math.max(l1, l2);
        }
        if (l1 > r2) {
            return findMax(a, b, start, mid - 1, k);
        } else {
            return findMax(a, b, mid + 1, end, k);
        }
    }

    public static void main(String[] args) {
        int a[] = { 2, 3, 6, 7, 9 };
        int b[] = { 1, 4, 8, 10 };
        int k = 5;
        int minIndex = Math.max(0, k - a.length);
        int highIndex = Math.min(k, b.length);
        System.out.println(findMax(b, a, minIndex, highIndex, k));
    }

}
