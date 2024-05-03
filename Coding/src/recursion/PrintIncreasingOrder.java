package recursion;

public class PrintIncreasingOrder {

    public static void printInIncreasingOrder(int num) {
        if (num == 1) {
            System.out.print(num + "->");
            return;
        }
        printInIncreasingOrder(num - 1);
        System.out.print(num + ">");

    }

    public static void main(String[] args) {
        int num = 10;
        printInIncreasingOrder(num);
    }

}
