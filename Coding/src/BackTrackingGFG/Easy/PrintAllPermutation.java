package BackTrackingGFG.Easy;

import java.util.ArrayList;
import java.util.HashSet;

public class PrintAllPermutation {

    public static void findPermutation(StringBuilder sb, int currentIndex, ArrayList<String> result, String curResult) {
        if (currentIndex >= sb.length()) {

            result.add(curResult);

            return;
        }
        for (int i = currentIndex; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(currentIndex));
            sb.setCharAt(currentIndex, temp);
            findPermutation(sb, currentIndex + 1, result, curResult + temp);
            sb.setCharAt(currentIndex, sb.charAt(i));
            sb.setCharAt(i, temp);
        }
    }

    public static void main(String[] args) {
        String s = "KK";
        StringBuilder sb = new StringBuilder(s);
        ArrayList<String> finalResult = new ArrayList<>();
        findPermutation(sb, 0, finalResult, "");
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < finalResult.size(); i++) {
            hs.add(finalResult.get(i));
        }
        ArrayList<String> finalResult1 = new ArrayList<>(hs);
        System.out.println(finalResult);
    }

}
