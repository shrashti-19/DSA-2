import java.util.*;

public class dijkstra {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.wt = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path; 

        public Pair(int n, int p) {
            this.node = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // min-heap based on path
        }
    }

    public static void dij(ArrayList<Edge>[] graph, int src) {
        int distance[] = new int[graph.length];

        // Initialize distances
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    int u = curr.node;
                    int v = e.dest;

                    if (distance[u] != Integer.MAX_VALUE && 
                        distance[u] + e.wt < distance[v]) {

                        distance[v] = distance[u] + e.wt;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 5, 5));

        dij(graph, 0);
    }
}