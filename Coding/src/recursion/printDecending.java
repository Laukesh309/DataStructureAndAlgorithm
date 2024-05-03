package recursion;

public class printDecending {
    public static void printNumber(int number) {
        if (number == 0) {
            return;
        }
        System.out.print(number + "->");
        printNumber(number - 1);
        return;
    }

    public static void main(String[] args) {
        int num = 5;
        printNumber(num);
    }

}
