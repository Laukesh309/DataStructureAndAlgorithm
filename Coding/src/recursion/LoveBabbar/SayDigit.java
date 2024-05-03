package recursion.LoveBabbar;

public class SayDigit {

    public static void printSayDigit(int n, String arr[]) {
        if (n == 0) {
            return;
        }
        int ques = n / 10;
        int rem = n % 10;
        printSayDigit(ques, arr);
        System.out.println(arr[rem]);
        return;

    }

    public static void main(String[] args) {
        int n = 412;
        String arr[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        printSayDigit(n, arr);
    }

}
