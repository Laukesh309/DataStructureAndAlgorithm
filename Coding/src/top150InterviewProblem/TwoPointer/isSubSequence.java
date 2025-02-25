package top150InterviewProblem.TwoPointer;

public class isSubSequence {

    public static boolean isSubSequence(String s, String t) {
        int first = 0;
        int second = 0;
        while (first < s.length() && second < t.length()) {
            if (s.charAt(first) == t.charAt(second)) {
                first++;
            }
            second++;
        }
        if (first == s.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubSequence(s, t));
    }

}
