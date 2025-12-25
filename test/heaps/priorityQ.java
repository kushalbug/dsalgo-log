import java.util.*;
public class priorityQ {

    public static class Student implements Comparable<Student> {
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
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("Alice", 10));
        pq.add(new Student("Bob", 20));
        pq.add(new Student("Charlie", 30));
        pq.add(new Student("David", 5));
        // System.out.println(pq.peek());
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove(); 
        }
    }
}