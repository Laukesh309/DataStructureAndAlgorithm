package String;

public class checkDivisibility7 {

    public static boolean findDivisibilityBySub(int number) {
        if (number == 0) {
            return true;
        }
        if (number < 7) {
            return false;
        }
        return findDivisibilityBySub(number - 7);
    }

    public static void main(String[] args) {
        int number = 7673;
        System.out.println(findDivisibilityBySub(number));
    }

}
