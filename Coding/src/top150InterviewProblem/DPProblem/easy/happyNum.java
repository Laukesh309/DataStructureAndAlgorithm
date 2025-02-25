package top150InterviewProblem.DPProblem.easy;

public class happyNum {

    public static boolean findHappyNumber(int n) {
        int number = n;
        while (number > 9) {
            int square = 0;
            while (number != 0) {
                int rem = number % 10;
                number = number / 10;
                rem = rem * rem;
                square = square + rem;
            }
            number = square;
        }
        if (number == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(findHappyNumber(n));
    }

}
