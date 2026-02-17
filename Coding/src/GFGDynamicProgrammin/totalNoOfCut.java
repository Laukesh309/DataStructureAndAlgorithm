package GFGDynamicProgrammin;

public class totalNoOfCut {

    public static int findTotalElement(String s, int start, int end, char value) {
        if (start == end) {
            return s.charAt(start) == value ? 1 : 0;
        }
        int ans = 0;
        for (int i = start + 1; i <= end; i = i + 2) {
            char currentOperator = s.charAt(i);
            int leftTrue = findTotalElement(s, start, i - 1, 'T');
            int rightTrue = findTotalElement(s, i + 1, end, 'T');
            int leftFalse = findTotalElement(s, start, i - 1, 'F');
            int rightFalse = findTotalElement(s, i + 1, end, 'F');
            if (currentOperator == '^') {
                if (value == 'F') {
                    ans = ans + leftTrue * rightTrue + rightFalse * leftFalse;
                } else {
                    ans = ans + leftTrue * rightFalse + leftFalse * rightTrue;
                }
            }
            if (currentOperator == '&') {
                if (value == 'F') {
                    ans = ans + leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                } else {
                    ans = ans + leftTrue * rightTrue;
                }
            }
            if (currentOperator == '|') {
                if (value == 'F') {
                    ans = ans + leftFalse * rightFalse;
                } else {
                    ans = ans + leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(findTotalElement(s, 0, s.length() - 1, 'T'));

    }
}
