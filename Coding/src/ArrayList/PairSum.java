package ArrayList;

import java.util.ArrayList;

public class PairSum {

    public static void findPair(ArrayList<Integer> list, int digit) {
        int initialPointer = 0;
        int lastPointer = list.size() - 1;
        while (initialPointer < lastPointer) {
            if (list.get(initialPointer) + list.get(lastPointer) == digit) {
                System.out.println("found at " + initialPointer + " " + lastPointer);
                initialPointer++;
                lastPointer--;
            }
            if (list.get(initialPointer) + list.get(lastPointer) > digit) {
                lastPointer--;
            }
            if (list.get(initialPointer) + list.get(lastPointer) < digit) {
                initialPointer++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int digit = 5;
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
        System.out.println(list);
        findPair(list, digit);
    }

}
