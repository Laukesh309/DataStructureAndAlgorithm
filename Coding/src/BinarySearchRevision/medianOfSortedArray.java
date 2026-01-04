package BinarySearchRevision;

public class medianOfSortedArray {

    public static double findElement(int a[], int b[], int startIndex, int endIndex, int k) {

        int mid = (startIndex + endIndex) / 2;
        int mid2 = k - mid;
        int r1 = mid == a.length ? Integer.MAX_VALUE : a[mid];
        int l1 = mid == 0 ? Integer.MIN_VALUE : a[mid - 1];
        int r2 = mid2 == b.length ? Integer.MAX_VALUE : b[mid2];
        int l2 = mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1];
        if (r1 >= l2 && r2 >= l1) {
            if ((a.length + b.length) % 2 != 0) {
                System.out.println(l1 + " " + l2);
                return Math.min(r1, r2);
            } else {
                System.out.println(l1 + " " + l2 + " " + r1 + " " + r2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }
        if (r1 < l2) {
            return findElement(a, b, mid + 1, endIndex, k);
        } else {
            return findElement(a, b, startIndex, mid - 1, k);
        }

    }

    public static void main(String[] args) {
        int a[] = { 3, 4 };
        int b[] = { 1, 2, 6, 7 };
        int firstLength = a.length;
        int secondLength = b.length;
        int midElement = (a.length + b.length) / 2;
        int startIndex = Math.max(0, midElement - secondLength);
        int endIndex = Math.min(firstLength, midElement);
        System.out.println(midElement);
        System.out.println(findElement(a, b, startIndex, endIndex, midElement));

    }

}
