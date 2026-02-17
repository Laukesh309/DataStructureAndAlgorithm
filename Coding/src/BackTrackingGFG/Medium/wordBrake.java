package BackTrackingGFG.Medium;

import java.util.ArrayList;

public class wordBrake {

    public static void findAllPossibleWord(String s, ArrayList<String> dict,
            ArrayList<String> result, String curResult) {
        System.out.println(s);
        if (s.length() == 0) {
            result.add(new String(curResult));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i + 1))) {
                findAllPossibleWord(s.substring(i + 1), dict, result, curResult + " " + s.substring(0, i + 1));
            }

        }
    }

    public static void main(String[] args) {
        String s = "likegfg";
        String dict[] = { "lik", "like", "egfg", "gfg" };
        ArrayList<String> dist2 = new ArrayList<>();
        for (int i = 0; i < dict.length; i++) {
            dist2.add(dict[i]);
        }
        ArrayList<String> result = new ArrayList<>();
        findAllPossibleWord(s, dist2, result, "");
        System.out.println(result);
        String[] finalResult = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i).trim();
        }
        return finalResult;

    }

}
