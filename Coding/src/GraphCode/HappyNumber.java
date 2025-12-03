package GraphCode;

import java.util.HashSet;

public class HappyNumber {

    public static boolean findHappyNumber(int n) {
        HashSet<Integer> tempSet = new HashSet<>();
        int currentNumber = n;
        while (currentNumber != 1) {
            if (tempSet.contains(currentNumber)) {
                return false;
            }
            tempSet.add(currentNumber);
            int nextNumber = 0;
            while (currentNumber != 0) {
                int rem = currentNumber % 10;
                currentNumber = currentNumber / 10;
                nextNumber = nextNumber + rem * rem;
            }
            currentNumber = nextNumber;
        }
        return true;

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(findHappyNumber(n));
    }

}
