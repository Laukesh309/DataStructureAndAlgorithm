package BinarySearchTree;

public class countingBST {

    public static int findNoOfBST(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += findNoOfBST(i - 1) + findNoOfBST(n - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(findNoOfBST(n));
    }

}
