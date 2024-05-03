package HashMap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueueRankAndStudent {

    static class Student implements Comparable<Student> {
        int rank;
        String name;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student st) {
            return st.rank - this.rank;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("laukesh", 12));
        pq.add(new Student("mukesh", 20));
        while (!pq.isEmpty()) {
            System.out.println(pq.remove().name);
        }
    }

}
