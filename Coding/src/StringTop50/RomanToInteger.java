package StringTop50;

import java.util.HashMap;
import java.util.Stack;

public class RomanToInteger {

    public static int convertRomanToInteger(String str, HashMap<Character, Integer> hm) {
        if (str.isEmpty()) {
            return 0;
        }
        Stack<Integer> result = new Stack<>();
        char prev = str.charAt(0);
        result.push(hm.get(prev));
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (hm.get(prev) < hm.get(curr)) {
                int top = result.pop();
                result.push(hm.get(curr) - top);
            } else {
                result.push(hm.get(curr));
            }
            prev = curr;
        }
        int finalResult = 0;
        while (!result.isEmpty()) {
            finalResult = finalResult + result.pop();
        }
        return finalResult;
    }

    public static int iterationWays(String str, HashMap<Character, Integer> hm) {

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && hm.get(str.charAt(i)) < hm.get(str.charAt(i + 1))) {
                result = result + hm.get(str.charAt(i + 1)) - hm.get(str.charAt(i));
                i++;
            } else {
                result = result + hm.get(str.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        String str = "MCMIV";
        // System.out.println(convertRomanToInteger(str, hm));
        iterationWays(str, hm);

    }

}
