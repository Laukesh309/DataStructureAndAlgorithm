package GreedyAlgorithm;

public class LemonideChange {

    public static void main(String[] args) {
        int bills[] = { 5, 5, 10, 10, 20 };
        int result[] = { 0, 0, 0 };
        for (int i = 0; i < bills.length; i++) {
            int currentCast = bills[i];
            if (currentCast == 5) {
                result[0]++;
            } else if (currentCast == 10) {
                if (result[0] > 0) {
                    result[0]--;
                    result[1]++;
                } else {
                    System.out.println("false");
                    return;
                }
            } else {
                if (result[0] > 0 && result[1] > 0) {
                    result[0]--;
                    result[1]--;
                    result[2]++;
                } else if (result[0] >= 3) {
                    result[0] = result[0] - 3;
                } else {
                    System.out.println("fasle");
                    return;
                }
            }
        }
        System.out.println("true");

    }

}
