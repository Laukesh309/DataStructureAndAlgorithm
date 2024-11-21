package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllParenthesis {

    public static void findAllParanthesis(int n, String result, int left, List<String> finalResult) {
        if (n == 0) {
            if (left == 0) {
                finalResult.add(result);
            }

            return;
        }
        if (left > 0) {
            findAllParanthesis(n - 1, result + ")", left - 1, finalResult);
            findAllParanthesis(n - 1, result + "(", left + 1, finalResult);
        } else {
            findAllParanthesis(n - 1, result + "(", left + 1, finalResult);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> finalResult = new ArrayList<>();
        findAllParanthesis(2 * n, "", 0, finalResult);
        System.out.println(finalResult);

    }
}
