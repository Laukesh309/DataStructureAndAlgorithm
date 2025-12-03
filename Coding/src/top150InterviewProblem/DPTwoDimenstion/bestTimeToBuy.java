package top150InterviewProblem.DPTwoDimenstion;

public class bestTimeToBuy {

    public static int getMaxProfit(int price[]) {
        int maxValue = 0;
        int buy = Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            maxValue = Math.max(price[i] - buy, maxValue);
            buy = Math.min(price[i], buy);

        }
        return maxValue;
    }

    public static void main(String[] args) {
        int price[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(getMaxProfit(price));
    }

}
