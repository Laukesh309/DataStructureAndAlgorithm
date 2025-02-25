package top150InterviewProblem.DPProblem.medium;

public class trailingFact {

    public static int findNoZero(int n) {
        if (n == 0) {
            return 0;
        }
        int totalNumberOfZero = 0;
        while (n != 0) {
            totalNumberOfZero += n / 5;
            n = n / 5;
        }
        return totalNumberOfZero;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(findNoZero(n));
    }

}
