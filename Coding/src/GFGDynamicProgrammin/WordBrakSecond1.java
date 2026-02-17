package GFGDynamicProgrammin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBrakSecond1 {

    public static void findAllString(String s, Set<String> st, int currentIndex, String result,
            ArrayList<String> finalResult) {
        if (currentIndex >= s.length()) {

            finalResult.add(new String(result.trim()));
            return;
        }
        String tempString = "";
        for (int i = currentIndex; i < s.length(); i++) {
            tempString = s.substring(currentIndex, i + 1);
            if (st.contains(tempString)) {
                findAllString(s, st, i + 1, result + " " + tempString, finalResult);
            }
        }

    }

    public static void main(String[] args) {

        String s = "likegfg";
        String dict[] = { "lik", "like", "egfg", "gfg" };
        Set<String> st = new HashSet<>();
        for (int i = 0; i < dict.length; i++) {
            st.add(dict[i]);
        }
        ArrayList<String> finalResult = new ArrayList<>();
        findAllString(s, st, 0, "", finalResult);
        System.out.println(finalResult);
    }

}
