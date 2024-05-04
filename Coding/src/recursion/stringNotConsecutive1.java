package recursion;

public class stringNotConsecutive1 {

    public static void printAllString(int n, String result, char previousChar) {
        if (n == 0) {
            System.out.println(result);
            return;
        }
        if (previousChar == '1') {
            printAllString(n - 1, result + '0', '0');
        } else {
            printAllString(n - 1, result + '0', '0');
            printAllString(n - 1, result + '1', '1');
        }
        return;
    }

    public static void main(String[] args) {
        int n = 3;
        char ch = ' ';
        printAllString(n, "", ch);
    }

}
