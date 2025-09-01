package september;
import java.util.PriorityQueue;

class Solution {
    static class ClassInfo {
        int p, t;
        ClassInfo(int p, int t) { this.p = p; this.t = t; }
        double gain() {
            // (p+1)/(t+1) - p/t
            return ((double)(t - p)) / (t * (double)(t + 1));
        }
        double ratio() {
            return (double) p / t;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.gain(), a.gain()) // max-heap by gain
        );

        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        for (int k = 0; k < extraStudents; k++) {
            ClassInfo top = pq.poll();
            top.p += 1;
            top.t += 1;
            pq.offer(top);
        }

        double sum = 0.0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            sum += pq.poll().ratio();
        }
        return sum / n;
    }
}
