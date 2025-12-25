import java.util.*;

public class nearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distance;
        int idx;

        public Point(int x, int y, int distance, int idx) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distance - p2.distance;
        }
    }
    public static void main(String args[]) {
        int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<pts.length; i++){
            int x = pts[i][0];
            int y = pts[i][1];
            int distance = x*x + y*y;
            pq.add(new Point(x, y, distance, i));
        }

        //nearest k cars
        for(int i=0; i<k; i++){
            System.out.println("Car " + pq.remove().idx);
        }
    }
}