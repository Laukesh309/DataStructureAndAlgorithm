package HeapChapter;

import java.util.PriorityQueue;

public class nearByCar {
    static class Car implements Comparable<Car> {
        int distance;
        int index;

        Car(int distance, int index) {
            this.distance = distance;
            this.index = index;
        }

        @Override
        public int compareTo(Car current) {
            return this.distance - current.distance;
        }

    }

    public static void main(String[] args) {
        int position[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        PriorityQueue<Car> pr = new PriorityQueue<>();
        for (int i = 0; i < position.length; i++) {
            int distance = position[i][0] * position[i][0] + position[i][1] * position[i][1];
            Car newCar = new Car(distance, i);
            pr.add(newCar);

        }

        int key = 2;
        int initialDistance = 1;

        while (initialDistance <= key) {
            System.out.println("C" + pr.peek().index);
            pr.remove();
            initialDistance++;
        }

    }

}
