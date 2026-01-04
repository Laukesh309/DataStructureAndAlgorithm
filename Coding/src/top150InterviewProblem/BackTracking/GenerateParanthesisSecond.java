package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesisSecond {

    public static void generateParanthesis(int n, int one, String result, List<String> finalResult) {
        System.out.println(n);
        if (n == 0) {
            finalResult.add(result);
            return;
        }
        if (one > n) {
            return;
        }
        if (one > 0) {
            generateParanthesis(n - 1, one - 1, result + ")", finalResult);
        }
        generateParanthesis(n, one + 1, result + "(", finalResult);

    }

    public static void main(String[] args) {
        int n = 1;
        List<String> finalResult = new ArrayList<>();
        generateParanthesis(n, 0, "", finalResult);
        System.out.println(finalResult);

    }
}
