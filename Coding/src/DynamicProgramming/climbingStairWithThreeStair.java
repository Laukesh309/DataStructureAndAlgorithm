package DynamicProgramming;

public class climbingStairWithThreeStair {

    public static int findNumberOfWaysThreeStatir(int totalStair, int climbValue[]) {
        if (totalStair == 0) {
            return 1;
        }
        if (totalStair < 0) {
            return 0;
        }
        if (climbValue[totalStair] != 0) {
            return climbValue[totalStair];
        }
        climbValue[totalStair] = findNumberOfWaysThreeStatir(totalStair - 1, climbValue)
                + findNumberOfWaysThreeStatir(totalStair - 2, climbValue)
                + findNumberOfWaysThreeStatir(totalStair - 3, climbValue);
        return climbValue[totalStair];
    }

    public static void main(String[] args) {
        int totalStair = 5;
        int climbValue[] = new int[totalStair + 1];
        System.out.println(findNumberOfWaysThreeStatir(totalStair, climbValue));

    }

}
