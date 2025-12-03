package BinarySearch;

public class medianSorted {

    public static double findMedian(int num1[], int num2[]) {
        int length1 = num1.length;
        int length2 = num2.length;
        int num3[] = new int[length1 + length2];
        int firstPointer = 0;
        int secondPointer = 0;
        int thirdPointer = 0;
        while (firstPointer < num1.length && secondPointer < num2.length) {
            if (num1[firstPointer] <= num2[secondPointer]) {
                num3[thirdPointer++] = num1[firstPointer++];
            } else if (num2[secondPointer] < num1[firstPointer]) {
                num3[thirdPointer++] = num2[secondPointer++];
            }
        }
        while (firstPointer < num1.length) {
            num3[thirdPointer++] = num1[firstPointer++];
        }
        while (secondPointer < num2.length) {
            num3[thirdPointer++] = num2[secondPointer++];
        }
        for (int i = 0; i < num3.length; i++) {
            System.out.println(num3[i]);
        }
        if (num3.length % 2 != 0) {
            return num3[(num3.length + 1) / 2];
        }
        int firstValue = num3.length / 2;
        int secondValue = firstPointer - 1;

        return (double) (num3[firstValue] + num3[secondValue]) / 2;

    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2 };
        int nums2[] = { 3, 4 };
        System.out.println(findMedian(nums1, nums2));
    }

}
