package ArrayList;

import java.util.ArrayList;

public class sortedRotatedPairSum {

    public static int findPivotElement(ArrayList<Integer> list) {
        int startingPointer = 0;
        while (startingPointer < list.size()) {
            if (list.get(startingPointer) > list.get(startingPointer + 1)) {
                return startingPointer;
            }
            startingPointer++;

        }
        return -1;

    }

    public static boolean isTargetPresent(ArrayList<Integer> list, int target) {
        int startingIndex = findPivotElement(list) + 1;
        int lastIndex = findPivotElement(list);
        int totalLenght = list.size();
        while (startingIndex != lastIndex) {
            if (list.get(startingIndex) + list.get(lastIndex) == target) {
                return true;
            }
            if (list.get(startingIndex) + list.get(lastIndex) > target) {
                lastIndex = (totalLenght + lastIndex - 1) % totalLenght;
            }
            if (list.get(startingIndex) + list.get(lastIndex) < target) {
                startingIndex = (startingIndex + 1) % totalLenght;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(40);
        int target = 16;
        System.out.println(isTargetPresent(list, target));
    }

}
