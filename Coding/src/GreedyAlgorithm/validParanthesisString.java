package GreedyAlgorithm;

public class validParanthesisString {

    public static boolean findValidParanthesis(String str, int currentIndex, int currentCount) {
        if (currentCount < 0) {
            return false;
        }
        if (currentIndex >= str.length()) {
            if (currentCount == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (str.charAt(currentIndex) == '(') {
            return findValidParanthesis(str, currentIndex + 1, currentCount + 1);
        } else if (str.charAt(currentIndex) == ')') {
            return findValidParanthesis(str, currentIndex + 1, currentCount - 1);
        } else {
            boolean leftSubstitute = findValidParanthesis(str, currentIndex + 1, currentCount + 1);
            boolean emptySubstitute = findValidParanthesis(str, currentIndex + 1, currentCount);
            boolean rightSubstitute = findValidParanthesis(str, currentIndex + 1, currentCount - 1);
            return leftSubstitute || emptySubstitute || rightSubstitute;
        }
    }

    public static void main(String[] args) {
        String str = "(*))";
        System.out.println(findValidParanthesis(str, 0, 0));
    }

}
