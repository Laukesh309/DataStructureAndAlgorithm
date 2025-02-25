package BackTrackingRevision;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void GenerateParanthesis(int n, int left, int rightParanthesis, String result,
            List<String> finalResult) {
        if (n == 0 && left == 0) {

            finalResult.add(result);
            return;
        }
        if (n < 0) {
            return;

        }
        if (left >= 1) {
            GenerateParanthesis(n - 1, left - 1, rightParanthesis, result + ")", finalResult);
        }
        GenerateParanthesis(n - 1, left + 1, rightParanthesis, result + "(", finalResult);

    }

    public static void findMaximum(int n, int open, int close, String result, List<String> finalResult) {
        if (open == n && close == n) {
            finalResult.add(result);
            return;
        }
        if (open < n) {
            findMaximum(n, open + 1, close, result + "(", finalResult);
        }
        if (close < open) {
            findMaximum(n, open, close + 1, result + ")", finalResult);
        }
        return;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> finalResult = new ArrayList<>();
        // GenerateParanthesis(2 * n, 0, 0, "", finalResult);
        // System.out.println(finalResult);
        findMaximum(n, 0, 0, "", finalResult);
        System.out.println(finalResult);

    }

}
