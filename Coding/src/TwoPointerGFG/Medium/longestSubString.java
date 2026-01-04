package TwoPointerGFG.Medium;

public class longestSubString {

    public static int langest(String s, int k) {
        int left = 0;
        int right = 0;
        int totalCount = 0;
        int tempArray[] = new int[26];
        int maxLength = -1;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (tempArray[currentChar - 'a'] == 0) {
                totalCount++;
            }
            tempArray[currentChar - 'a'] = tempArray[currentChar - 'a'] + 1;
            while (left < right && totalCount > k) {
                int leftIndex = s.charAt(left) - 'a';
                tempArray[leftIndex] = tempArray[leftIndex] - 1;
                if (tempArray[leftIndex] == 0) {
                    totalCount--;
                }
                left++;
            }
            if (totalCount == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aabaaab";
        int k = 2;
        System.out.println(langest(s, k));
    }
}
