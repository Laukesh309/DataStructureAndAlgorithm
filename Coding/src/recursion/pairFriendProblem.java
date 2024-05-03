package recursion;

public class pairFriendProblem {

    public static int findTotalFriendPair(int totalFriend) {
        if (totalFriend == 0 || totalFriend == 1) {
            return 1;
        }
        return findTotalFriendPair(totalFriend - 1) + findTotalFriendPair(totalFriend - 2);

    }

    public static void main(String[] args) {
        int numberOfFriend = 2;
        int totalNumberOfWays = findTotalFriendPair(numberOfFriend);
        System.out.println(totalNumberOfWays);
    }

}
