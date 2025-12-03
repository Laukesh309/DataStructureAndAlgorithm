package BackTrackingTop20;

import java.util.ArrayList;
import java.util.HashSet;

import HeapChapter.heapSort;

public class permutationString {

    public static void findPermutation(String s, int currentIndex, ArrayList<String> result, StringBuilder curString) {
        if (currentIndex == s.length()) {
            result.add(curString.toString());
            return;
        }
        for (int i = currentIndex; i < s.length(); i++) {
            char temp = curString.charAt(currentIndex);
            curString.setCharAt(currentIndex, curString.charAt(i));
            curString.setCharAt(i, temp);
            findPermutation(s, currentIndex + 1, result, curString);
            curString.setCharAt(i, curString.charAt(currentIndex));
            curString.setCharAt(currentIndex, temp);
        }

    }

    public static void main(String[] args) {
        String s = "AA";
        ArrayList<String> result = new ArrayList<>();
        findPermutation(s, 0, result, new StringBuilder(s));
        HashSet<String> hs = new HashSet<>(result);
        System.out.println(result);
        ArrayList<String> finalResult = new ArrayList<>(hs);
        System.out.println(hs.toString());
    }

}
