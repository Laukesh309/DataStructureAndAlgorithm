package top150InterviewProblem.slidingWindowRevision;

import java.util.HashMap;

public class noOfSubStringContainingAllCharacter {

    public static int findTotalSubString(String str) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int left = 0;
        int right = 0;
        int total = 0;
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            while (hs.size() >= 3) {
                total += str.length() - right;
                hs.put(str.charAt(left), hs.get(str.charAt(left)) - 1);
                if (hs.get(str.charAt(left)) == 0) {
                    hs.remove(str.charAt(left));
                }
                left++;
            }
            right++;
        }
        return total;

    }

    public static int findMaxValue(String str) {
        int left = 0;
        int right = 0;
        int total = 0;
        int arr[] = new int[3];
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            arr[currentChar - 'a']++;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                total += str.length() - right;
                arr[str.charAt(left++) - 'a']--;
            }
            right++;
        }
        return total;
    }

    public int numberOfSubstrings(String str) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            while (hs.size() >= 3) {
                max = max + str.length() - right;
                hs.put(str.charAt(left), hs.get(str.charAt(left)) - 1);
                if (hs.get(str.charAt(left)) == 0) {
                    hs.remove(str.charAt(left));
                }
                left++;
            }
            right++;

        }
        return max;

    }

    public static void main(String[] args) {
        String str = "aaacb";
        System.out.println(findTotalSubString(str));
        System.out.println(findMaxValue(str));
    }

}
