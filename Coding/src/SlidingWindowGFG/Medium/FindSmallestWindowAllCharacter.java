package SlidingWindowGFG.Medium;

public class FindSmallestWindowAllCharacter {

    public static int findtotalCharacter(String str) {
        int charArray[] = new int[26];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charArray[currentChar - 'a'] == 0) {
                count++;
            }
            charArray[currentChar - 'a']++;
        }
        return count;
    }

    public static int findMinimumWindow(String str, int totalChar) {
        int left = 0;
        int resultArray[] = new int[26];
        int totalLenght = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (resultArray[curChar - 'a'] == 0) {
                totalLenght++;
            }
            resultArray[curChar - 'a']++;
            while (totalLenght == totalChar && left <= i) {
                minLength = Math.min(minLength, i - left + 1);
                resultArray[str.charAt(left) - 'a']--;
                if (resultArray[str.charAt(left) - 'a'] == 0) {
                    totalLenght--;
                }
                left++;
            }
        }
        System.out.println(minLength);
        return minLength;
    }

    public static void main(String[] args) {
        String str = "aaab";
        int totalChar = findtotalCharacter(str);
        System.out.println(totalChar);
        System.out.println(findMinimumWindow(str, totalChar));

    }

}
