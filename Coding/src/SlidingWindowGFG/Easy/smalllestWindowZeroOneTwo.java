package SlidingWindowGFG.Easy;

public class smalllestWindowZeroOneTwo {

    public static int findMinimumWindow(String s) {
        int inputArray[] = new int[3];
        int maxSubArray = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            inputArray[ch - '0']++;
            while (inputArray[0] > 0 && inputArray[1] > 0 && inputArray[2] > 0) {
                maxSubArray = Math.min(maxSubArray, right - left + 1);
                inputArray[s.charAt(left++) - '0']--;
            }
            right++;
        }
        return maxSubArray == Integer.MAX_VALUE ? -1 : maxSubArray;
    }

    public static void main(String[] args) {
        String S = "12121";
        findMinimumWindow(S);
    }

}
