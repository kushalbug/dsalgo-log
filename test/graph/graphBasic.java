import java.util.*;
public class graphBasic {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!visited[e.dest]) {
                    q.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize the graph
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[1].add(new Edge(1, 3, 12));
        graph[2].add(new Edge(2, 4, 10));
        graph[3].add(new Edge(3, 4, 5));

        for(int i=0; i<graph[0].size(); i++){
            Edge e = graph[0].get(i);
            System.out.println("Edge from " + e.src + " to " + e.dest + " with weight " + e.weight);
        }
    }
}