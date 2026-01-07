package SlidingWindowGFG.Medium;

public class ExactlyKDistinctCharacter {

    public static int findTotalElement(String s, int k) {
        int totalDistinct = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int charArray[] = new int[26];
        int count = 0;
        while (rightIndex < s.length()) {
            char curChar = s.charAt(rightIndex);
            if (charArray[curChar - 'a'] == 0) {
                totalDistinct++;
            }
            charArray[curChar - 'a']++;
            while (totalDistinct >= k) {
                char leftChar = s.charAt(leftIndex);
                charArray[leftChar - 'a']--;
                if (charArray[leftChar - 'a'] == 0) {
                    totalDistinct--;
                }
                leftIndex++;
            }
            count = count + rightIndex - leftIndex + 1;
            rightIndex++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(findTotalElement(s, k));
        System.out.println(findTotalElement(s, k + 1));
    }

}
