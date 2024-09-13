package top150InterviewProblem.Array;

import java.util.Arrays;

public class findMajorityElement {

    public static int findMajorityElement(int arr[]) {
        int target = arr.length / 2;
        Arrays.sort(arr);

        int priveousElement = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == priveousElement) {
                counter++;
                if (counter > target) {
                    return priveousElement;
                }
            } else {

                priveousElement = arr[i];
                counter++;
            }

        }
        return priveousElement;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 3 };
        System.out.println(findMajorityElement(arr));
    }
}
