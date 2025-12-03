package SlidingWindow;

public class maximumPoint {

    public static void main(String[] args) {
        int cardPoints[] = { 9, 7, 7, 9, 7, 7, 9 };
        int k = 7;
        int length = cardPoints.length;
        int right = cardPoints.length - 1;
        int totalSum = 0;
        while (right >= length - k) {
            totalSum = totalSum + cardPoints[right];
            right--;
        }
        int maxValue = totalSum;
        int left = 0;
        System.out.println(right);
        while (left < k) {
            right++;
            totalSum = totalSum - cardPoints[right] + cardPoints[left];
            maxValue = Math.max(maxValue, totalSum);
            left++;
        }
        System.out.println(maxValue);
    }

}
