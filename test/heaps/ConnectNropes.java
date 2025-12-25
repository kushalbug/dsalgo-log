import java.util.*;
public class ConnectNropes {
    public static void main(String args[]) {
        int[] ropes = {2, 3, 3, 4, 6 };

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) {
            pq.add(rope);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            int sum = first + second;
            cost += sum;
            pq.add(sum);
        }

        System.out.println("Minimum cost to connect ropes: " + cost);
    }
}