package GreedyAlgorithm;

import java.util.HashMap;

public class lemonadeChange {

    public static boolean isPossible(int changes[]) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < changes.length; i++) {
            if (changes[i] == 5) {
                hm.put(changes[i], hm.getOrDefault(changes[i], 0) + 1);
            }
            if (changes[i] == 10) {
                if (hm.containsKey(5)) {
                    hm.put(5, hm.get(5) - 1);
                    hm.put(10, hm.getOrDefault(10, 0) + 1);
                } else {
                    return false;
                }
            }
            if (changes[i] == 20) {
                if (hm.containsKey(5) && hm.containsKey(10)) {
                    hm.put(5, hm.get(5) - 1);
                    hm.put(10, hm.get(10) - 1);
                    hm.put(20, hm.getOrDefault(20, 0) + 1);

                } else if (hm.containsKey(5)) {
                    if (hm.get(5) >= 3) {
                        hm.put(5, hm.get(5) - 3);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (hm.containsKey(5) && hm.get(5) == 0) {
                hm.remove(5);
            }
            if (hm.containsKey(10) && hm.get(10) == 0) {
                hm.remove(10);
            }
        }
        return true;
    }

    public static boolean findIndex(int changes[]) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < changes.length; i++) {
            if (changes[i] == 5) {
                five++;
            }
            if (changes[i] == 10) {
                ten++;
                five--;
            }
            if (changes[i] == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                    twenty++;
                } else if (ten > 0) {
                    return false;
                } else {
                    five = five - 3;
                }
            }

            if (five < 0 || ten < 0 || twenty < 0) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int changes[] = { 5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5 };
        System.out.println(isPossible(changes));
        System.out.println(findIndex(changes));
    }

}
