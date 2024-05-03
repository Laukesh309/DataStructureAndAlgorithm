package HeapChapter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueue {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(10);
        // pq.add(20);
        // pq.add(1);
        // pq.add(5);
        // pq.add(6);
        // while (!pq.isEmpty()) {
        // System.out.print(pq.peek() + " ");
        // pq.remove();
        // }
        pq.add(new Student("laukesh", 3));
        pq.add(new Student("mukesh", 5));
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name);
            pq.remove();

        }
    }

}
