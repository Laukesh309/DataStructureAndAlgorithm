package top150InterviewProblem.String;

public class rotateString {

    public static boolean rotateString(String s, String goal, int currentIndex) {

        if (currentIndex >= s.length()) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        char ch = s.charAt(0);
        String newString = s.substring(1) + ch;
        return rotateString(newString, goal, ++currentIndex);

    }

    public static boolean isRotated(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abced";
        System.out.println(rotateString(s, goal, 0));
        ;
    }

}
