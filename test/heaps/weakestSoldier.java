import java.util.PriorityQueue;

public class weakestSoldier {
    static class row implements Comparable<row> {
        int soldierCount;
        int index;

        row(int soldierCount, int index) {
            this.soldierCount = soldierCount;
            this.index = index;
        }

        @Override
        public int compareTo(row r2) {
            if (this.soldierCount == r2.soldierCount) {
                return this.index - r2.index;
            } else {
                return this.soldierCount - r2.soldierCount;
            }
        }
    }
    public static void main(String args[]) {
        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        int k = 2;

        PriorityQueue<row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[i].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new row(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.println("Row " + pq.remove().index);
        }
    }
}