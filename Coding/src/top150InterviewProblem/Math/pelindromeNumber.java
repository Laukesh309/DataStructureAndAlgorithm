package top150InterviewProblem.Math;

public class pelindromeNumber {

    public static boolean findPelindrome(int num) {
        String str = Integer.toString(num);
        int first = 0;
        int last = str.length() - 1;
        while (first <= last) {
            if (str.charAt(first) != str.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = -121;
        System.out.println(findPelindrome(num));
    }

}
