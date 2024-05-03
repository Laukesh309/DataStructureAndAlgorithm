package DynamicProgramming;

public class climbingStair {

    public static int totalNumberOfWaysToGoNthStair(int totalStair, int totalStairCount[]) {
        if (totalStair == 0 || totalStair == 1) {
            return 1;
        }
        if (totalStairCount[totalStair] != 0) {
            return totalStairCount[totalStair];
        }
        totalStairCount[totalStair] = totalNumberOfWaysToGoNthStair(totalStair - 1, totalStairCount)
                + totalNumberOfWaysToGoNthStair(totalStair - 2, totalStairCount);
        return totalStairCount[totalStair];
    }

    public static void main(String[] args) {
        int totalStair = 4;
        int totalStairCount[] = new int[totalStair + 1];
        System.out.println(totalNumberOfWaysToGoNthStair(totalStair, totalStairCount));
    }

}
