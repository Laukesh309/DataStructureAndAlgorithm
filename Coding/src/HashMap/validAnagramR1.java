package HashMap;

import java.util.HashMap;

public class validAnagramR1 {

    public static void main(String[] args) {
        // String st = "race";
        // String et = "care";
        // String st = "heart";
        // String et = "earth";
        // String st = "tulip";
        // String et = "lipid";
        String st = "knee";
        String et = "keenlaukehs";

        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < st.length(); i++) {
            hm.put(st.charAt(i), hm.getOrDefault(st.charAt(i), 0) + 1);
        }
        for (int i = 0; i < et.length(); i++) {
            hm2.put(et.charAt(i), hm2.getOrDefault(et.charAt(i), 0) + 1);
        }

        if (hm.equals(hm2)) {
            System.out.println("Valid Enagram");
        } else {
            System.out.println("Invalid Enagram");
        }

    }

}
