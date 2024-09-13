package top150InterviewProblem.HashMap;

import java.util.HashMap;
import java.util.regex.Pattern;

public class IsomarphicString {

    public static boolean findIsomerphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.containsKey(s.charAt(i))) {
                if (hs.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (hs.values().contains(t.charAt(i))) {
                    return false;
                }
                hs.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;

    }

    // second Approach
    public static boolean findIsomorphicSecondApproach(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> firstHashMap = new HashMap<>();
        HashMap<Character, Character> secondHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (firstHashMap.containsKey(s.charAt(i)) ||
                    secondHashMap.containsKey(t.charAt(i))) {
                if (firstHashMap.containsKey(s.charAt(i)) && firstHashMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
                if (secondHashMap.containsKey(t.charAt(i)) && secondHashMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }

            } else {
                firstHashMap.put(s.charAt(i), t.charAt(i));
                secondHashMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public static boolean findPatternMatching(String pattern, String s) {
        String[] str1 = s.split(" ");
        if (pattern.length() != str1.length) {
            return false;
        }
        HashMap<Character, String> firstMap = new HashMap<>();
        HashMap<String, Character> secondHashMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentPattern = str1[i];
            System.out.println(currentChar + " " + currentPattern + " " + firstMap + " " + secondHashMap);
            if (firstMap.containsKey(currentChar) || secondHashMap.containsKey(currentPattern)) {
                if (firstMap.containsKey(currentChar) && !firstMap.get(currentChar).equals(currentPattern)) {
                    return false;
                }
                if (secondHashMap.containsKey(currentPattern) && secondHashMap.get(currentPattern) != currentChar) {
                    System.out.println(currentChar + "  2 " + currentPattern + " " + firstMap + " " + secondHashMap);
                    return false;
                }

            } else {
                firstMap.put(currentChar, currentPattern);
                secondHashMap.put(currentPattern, currentChar);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        // String s = "paper";
        String t = "dog cat cat dog";
        String s = "abba";
        // System.out.println(findIsomorphicSecondApproach(s, t));
        System.out.println(findPatternMatching(s, t));
    }

}
