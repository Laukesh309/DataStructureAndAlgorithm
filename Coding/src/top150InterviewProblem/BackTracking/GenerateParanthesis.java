package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void generateParanthesis(int n, int open, int close, List<String> result, String tempResul) {
        if (n == 0 && open == close) {
            result.add(tempResul);
            return;
        }
        if (n == 0 || open < close) {
            return;
        }
        if (open < n) {
            generateParanthesis(n - 1, open + 1, close, result, tempResul + '(');
        }
        if (close < open) {
            generateParanthesis(n - 1, open, close + 1, result, tempResul + ')');
        }

    }

    public static void main(String[] args) {
        int n = 1;
        List<String> result = new ArrayList<>();
        generateParanthesis(2 * n, 0, 0, result, "");
        System.out.println(result);
    }

}
