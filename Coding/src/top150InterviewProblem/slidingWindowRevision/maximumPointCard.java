package top150InterviewProblem.slidingWindowRevision;

public class maximumPointCard {

    public static int findTotalSum(int cardPoints[], int k) {
        int rightSum = 0;
        int leftSum = 0;
        int right = cardPoints.length - 1;
        while (right >= cardPoints.length - k) {
            rightSum += cardPoints[right--];
        }
        int maxValue = rightSum + leftSum;
        right++;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
            rightSum = rightSum - cardPoints[right];
            maxValue = Math.max(rightSum + leftSum, maxValue);
            right++;
        }
        System.out.println(maxValue);
        return 0;
    }

    public static void main(String[] args) {
        int cardPoints[] = { 1, 79, 80, 1, 1, 1, 200, 1 };
        int k = 3;
        System.out.println(findTotalSum(cardPoints, k));
    }

}
