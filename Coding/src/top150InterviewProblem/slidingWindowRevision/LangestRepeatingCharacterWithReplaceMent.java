package top150InterviewProblem.slidingWindowRevision;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import recursion.LoveBabbar.ratInMaze;

public class LangestRepeatingCharacterWithReplaceMent {

    public static int maxLength(String str, int k) {
        int firstCounter = 0;
        int secondCounter = 0;
        int maxFrequence = 0;
        int result = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (secondCounter < str.length()) {
            hs.put(str.charAt(secondCounter), hs.getOrDefault(str.charAt(secondCounter), 0) + 1);
            maxFrequence = Math.max(maxFrequence, hs.get(str.charAt(secondCounter)));
            int totalChanges = secondCounter - firstCounter + 1 - maxFrequence;
            if (totalChanges <= k) {
                System.out.println(result + "   " + secondCounter + "   " + firstCounter);
                result = Math.max(secondCounter - firstCounter + 1, result);
            } else {
                while (totalChanges > k) {
                    hs.put(str.charAt(firstCounter), hs.get(str.charAt(firstCounter++)) - 1);
                    for (Integer values : hs.values()) {
                        maxFrequence = Math.max(maxFrequence, values);
                    }
                    totalChanges = secondCounter - firstCounter + 1 - maxFrequence;
                }
            }
            secondCounter++;
        }
        return result;
    }

    public int characterReplacement(String str, int k) {
        int left = 0;
        int right = 0;
        int maxSize = 0;
        int maxFrequecy = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            maxFrequecy = Math.max(maxFrequecy, hs.get(currentChar));
            int curSubString = right - left + 1 - maxFrequecy;
            if (curSubString <= k) {
                System.out.println(maxSize + "   " + right + "   " + left);
                maxSize = Math.max(maxSize, right - left + 1);
            } else {
                hs.put(str.charAt(left), hs.get(str.charAt(left)) - 1);
                maxFrequecy = 0;
                left++;
                System.out.println(hs);
                for (int freq : hs.values()) {
                    maxFrequecy = Math.max(freq, maxFrequecy);

                }
            }
            right++;

        }
        return maxSize;

    }

    public static void main(String[] args) {

        String str = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        System.out.println(maxLength(str, 4));

    }

}
