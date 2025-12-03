package SlidingWindow;

public class LangestSubStringKDistint {

    public static void main(String[] args) {
        String s = "aabaaab";
        int k = 2;
        int left = 0;
        int right = 0;
        int tempArray[] = new int[26];
        int count = 0;
        int max = 0;
        while (right < s.length()) {
            char currChar = s.charAt(right);
            if (tempArray[currChar - 'a'] == 0) {
                count++;
            }
            while (count > k) {
                tempArray[s.charAt(left) - 'a'] = tempArray[s.charAt(left) - 'a'] - 1;
                if (tempArray[s.charAt(left) - 'a'] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            tempArray[currChar - 'a'] = tempArray[currChar - 'a'] + 1;
            right++;
        }
        System.out.println(max);

    }

}
