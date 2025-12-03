package top150InterviewProblem.Array;

public class mergeSortedArray {

    public static void mergeArray(int nums1[], int nums2[], int n, int m) {
        int result[] = new int[m + n];
        int firstCounter = 0;
        int secondCounter = 0;
        int counter = 0;
        while (firstCounter < n && secondCounter < m) {
            if (nums1[firstCounter] < nums2[secondCounter]) {
                result[counter++] = nums1[firstCounter++];
            } else if (nums1[firstCounter] > nums2[secondCounter]) {
                result[counter++] = nums2[secondCounter++];

            } else {
                result[counter++] = nums1[firstCounter++];
                result[counter++] = nums2[secondCounter++];
            }

        }
        while (firstCounter < n) {
            result[counter++] = nums1[firstCounter++];

        }
        while (secondCounter < m) {
            result[counter++] = nums2[secondCounter++];

        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 0, 0, 0 };
        int nums2[] = { 2, 5, 6 };
        int m = 3;
        int n = 3;
        mergeArray(nums1, nums2, n, m);

    }

}
