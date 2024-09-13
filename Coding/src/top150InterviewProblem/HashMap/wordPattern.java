package top150InterviewProblem.HashMap;

import java.util.HashMap;

public class wordPattern {

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
            if (firstMap.containsKey(currentChar) || secondHashMap.containsKey(currentPattern)) {
                if (firstMap.containsKey(currentChar) && !firstMap.get(currentChar).equals(currentPattern)) {
                    return false;
                }
                if (secondHashMap.containsKey(currentPattern) && secondHashMap.get(currentPattern) != currentChar) {
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
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(findPatternMatching(pattern, s));

    }

}
