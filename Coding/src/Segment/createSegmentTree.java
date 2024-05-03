package Segment;

public class createSegmentTree {

    public static int findSum(int arr[], int initialIndex, int lastIndex) {
        int ans = 0;
        for (int i = initialIndex; i <= lastIndex; i++) {
            ans += arr[i];
        }
        return ans;
    }

    public static void getSegment(int arr[], int result[], int firstIndex, int lastIndex, int currentResultIndex) {
        int sum = findSum(arr, firstIndex, lastIndex);
        result[currentResultIndex] = sum;
        if (firstIndex >= lastIndex) {
            return;
        }

        int mid = (firstIndex + lastIndex) / 2;
        getSegment(arr, result, firstIndex, mid, 2 * currentResultIndex + 1);
        getSegment(arr, result, mid + 1, lastIndex, 2 * currentResultIndex + 2);

    }

    public static int findSegmentByBottomToTop(int arr[], int result[], int currentIndex, int start, int end) {
        if (start == end) {
            result[currentIndex] = arr[start];
            return result[currentIndex];
        }
        if (start > end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int leftValue = findSegmentByBottomToTop(arr, result, 2 * currentIndex + 1, start, mid);
        int rightValue = findSegmentByBottomToTop(arr, result, 2 * currentIndex + 2, mid + 1, end);
        result[currentIndex] = leftValue + rightValue;
        return leftValue + rightValue;
    }

    public static void printResult(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int getValueUtil(int result[], int currentIndex, int s1, int s2, int q1, int q2) {
        if (q1 >= s2 || s1 >= q2) {
            return 0;
        } else if (s1 >= q1 && s2 <= q2) {
            return result[currentIndex];
        } else {
            int mid = (s1 + s2) / 2;
            return getValueUtil(result, 2 * currentIndex + 1, s1, mid, q1, q2)
                    + getValueUtil(result, 2 * currentIndex + 2, mid + 1, s2, q1, q2);
        }

    }

    public static int getValue(int arr[], int result[], int q1, int q2) {
        int lastIndex = arr.length - 1;
        return getValueUtil(result, 0, 0, lastIndex, q1, q2);

    }

    public static int updateSegmentTreeUtil(int result[], int arr[], int currentIndex, int s1, int s2, int q1,
            int value) {
        // if (q1 < s1 || q1 > s2) {
        // return 0;
        // }
        if (s1 == s2 && s1 == q1 && s2 == q1) {
            int diff = value - result[currentIndex];
            arr[q1] = value;
            result[currentIndex] = value;
            return diff;
        }
        int mid = (s1 + s2) / 2;
        int value1 = 0;
        if (s1 >= q1 && q1 <= mid) {
            value1 = updateSegmentTreeUtil(result, arr, 2 * currentIndex + 1, s1, mid, q1, value);
        } else if (q1 >= mid && q1 <= s2) {
            value1 = updateSegmentTreeUtil(result, arr, 2 * currentIndex + 2, mid + 1, s2, q1, value);
        }
        result[currentIndex] = result[currentIndex] + value1;
        return value1;

    }

    public static void updateSegmentTree(int result[], int arr[], int i, int value) {

        updateSegmentTreeUtil(result, arr, 0, 0, arr.length - 1, i, value);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int result[] = new int[4 * arr.length];
        getSegment(arr, result, 0, arr.length - 1, 0);
        // printResult(result);
        findSegmentByBottomToTop(arr, result, 0, 0, arr.length - 1);

        printResult(result);
        System.out.println();
        // System.out.println(getValue(arr, result, 2, 5));
        updateSegmentTree(result, arr, 4, 10);
        printResult(result);

    }

}
