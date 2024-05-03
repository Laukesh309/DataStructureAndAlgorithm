package HashMap;

import java.util.HashMap;
import java.util.Set;

public class validAnagram {

    public static boolean isValidAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            hm1.put(str1.charAt(i), hm1.getOrDefault(str1.charAt(i), 0) + 1);
            hm2.put(str2.charAt(i), hm2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        // for (Character key : hm1.keySet()) {
        // if (hm1.get(key) != hm2.get(key)) {
        // return false;
        // }
        // }
        return hm1.equals(hm2);
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
