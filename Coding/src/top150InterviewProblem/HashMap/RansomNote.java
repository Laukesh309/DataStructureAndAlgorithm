package top150InterviewProblem.HashMap;

import java.util.HashMap;

public class RansomNote {

    public static boolean isValidString(String ransomNote, String magazine) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            hs.put(magazine.charAt(i), hs.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (hs.containsKey(ransomNote.charAt(i)) && (hs.get(ransomNote.charAt(i)) > 0)) {
                hs.put(ransomNote.charAt(i), hs.get(ransomNote.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String ransomNote = "aab", magazine = "baa";
        System.out.println(isValidString(ransomNote, magazine));
    }
}
