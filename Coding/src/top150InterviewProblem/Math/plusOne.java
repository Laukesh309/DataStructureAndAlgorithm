package top150InterviewProblem.Math;

public class plusOne {

    public static int[] findPlusOne(int digit[]) {

        int que = digit[digit.length - 1] + 1 / 10;
        int rem = digit[digit.length - 1] % 10;

    }

    public static void main(String[] args) {
        int digit[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        for (int item : findPlusOne(digit)) {
            System.out.print(item + " ");
        }

    }

}
