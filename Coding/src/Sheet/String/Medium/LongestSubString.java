package Sheet.String.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import HashSet.hashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubString {

    public static int findLongestCommonSubString(String str) {

        int maxValue = Integer.MIN_VALUE;
        Queue<Character> currentString = new LinkedList<>();
        int initialPointer = 0;
        while (initialPointer < str.length()) {
            while (currentString.contains(str.charAt(initialPointer))) {
                currentString.remove();
            }
            currentString.add(str.charAt(initialPointer++));
            maxValue = Math.max(maxValue, currentString.size());
        }
        return maxValue == Integer.MIN_VALUE ? 0 : maxValue;

    }

    public static int findLangestCommonSubString(String str) {
        int initialPointer = 0;
        int secondPointer = 0;
        int maxValue = Integer.MIN_VALUE;
        HashSet<Character> hs = new HashSet<>();
        while (secondPointer < str.length()) {
            while (hs.contains(str.charAt(secondPointer))) {
                hs.remove(str.charAt(initialPointer++));
            }
            hs.add(str.charAt(secondPointer++));
            System.out.println(hs);
            maxValue = Math.max(maxValue, hs.size());

        }
        return maxValue == Integer.MIN_VALUE ? 0 : maxValue;
    }

    public static int findLangestCommonSubStringHashTable(String str) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            while (hs.get(currentChar) >= 2) {
                int leftValue = hs.get(str.charAt(left)) - 1;
                hs.put(str.charAt(left++), leftValue);
            }
            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(findLangestCommonSubStringHashTable(str));
    }
}
