package HashMap;

import java.util.HashMap;

public class validanagram1 {

    public static boolean isValidAnagram(String str1, String str2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            hm.put(str1.charAt(i), hm.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (!hm.containsKey(ch)) {
                return false;
            } else {
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
            }
        }
        if (hm.isEmpty()) {
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        // String str1 = "race";
        // String str2 = "care";

        // String str1 = "heart";
        // String str2 = "earth";

        String str1 = "tulip";
        String str2 = "lipid";

        System.out.println(isValidAnagram(str1, str2));
    }

}
