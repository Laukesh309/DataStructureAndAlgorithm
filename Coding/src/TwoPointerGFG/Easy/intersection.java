package TwoPointerGFG.Easy;

import java.util.Arrays;

public class intersection {

    public static int findTotalIntersection(int a[], int b[]) {

        Arrays.sort(a);
        Arrays.sort(b);
        int left = 0;
        int right = 0;
        int total = 0;
        while (left < a.length && right < b.length) {
            while (left - 1 >= 0 && left < a.length && a[left] == a[left - 1]) {
                left++;
            }
            while (right - 1 >= 0 && right < b.length && b[right] == b[right - 1]) {
                right++;
            }
            if (left >= a.length || right >= b.length) {
                return total;
            }
            if (a[left] == b[right]) {
                System.out.println("total===>" + total);
                total += 1;
                left++;
                right++;
            } else if (a[left] < b[right]) {
                left++;
            } else {
                right++;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 3, 5, 6 };
        int b[] = { 3, 4, 5, 6, 7 };

        System.out.println(findTotalIntersection(a, b));

    }

}
