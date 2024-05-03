package ArrayList;

import java.util.ArrayList;

public class ContatainerMostWater {

    public static int maxContainer(ArrayList<Integer> list) {
        int max_Area = Integer.MIN_VALUE;
        int firstNumber = -1;
        int secondNumber = -1;
        for (int i = 0; i < list.size(); i++) {
            int currentFirstNumber = list.get(i);
            for (int j = i; j < list.size(); j++) {
                int currentSecondNumber = list.get(j);
                int width = j - i;
                int height = Math.min(currentFirstNumber, currentSecondNumber);
                int area = width * height;
                if (max_Area < area) {
                    firstNumber = i;
                    secondNumber = j;
                    max_Area = area;
                }
            }
        }
        System.out.println(firstNumber + " " + secondNumber);
        return max_Area;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(maxContainer(list));
    }

}
