package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class minWindowSubstring {
    public static boolean findCharacterContain(HashMap<Character, Integer> currentMap,
            HashMap<Character, Integer> tempMap) {
        for (Character element : tempMap.keySet()) {
            if (!currentMap.containsKey(element) || (currentMap.get(element) < tempMap.get(element))) {
                return false;
            }
        }
        return true;

    }

    public static void findString(String s, String t) {
        int left = 0;
        int right = 0;
        String result = "";
        int size = Integer.MAX_VALUE;
        HashMap<Character, Integer> tempMap = new HashMap<>();
        HashMap<Character, Integer> currHashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tempMap.put(t.charAt(i), tempMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            currHashMap.put(s.charAt(right), currHashMap.getOrDefault(s.charAt(right), 0) + 1);
            while (findCharacterContain(currHashMap, tempMap)) {
                String tempString = s.substring(left, right + 1);
                if (tempString.length() < size) {
                    result = new String(tempString);
                    size = tempString.length();
                }
                currHashMap.put(s.charAt(left), currHashMap.get(s.charAt(left)) - 1);
                left++;
            }
            right++;

        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String s = "a", t = "aa";
        findString(s, t);

    }
}
