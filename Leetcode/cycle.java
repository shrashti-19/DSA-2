import java.util.*;

public class cycle{
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static boolean CycleUndirected(ArrayList<Edge>[]graph, int V){
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
           if(!visited[i]){
             if(bfscycle(graph, visited, i)){
               return true;
            }
        }
        
        //connected components
    }
     return false;
    }
    public static boolean bfscycle(ArrayList<Edge>[]graph, boolean[]visited, int curr ){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{curr,-1});
        visited[curr] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];

            for(int i=0 ; i<graph[node].size() ; i++){
                Edge e = graph[node].get(i);
                if(!visited[e.dest]){
                    visited[e.dest] = true;
                    q.add(new int[]{e.dest, node});
                }else if(e.dest!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++){
         graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,0));

        System.out.println("Cycle detection in undirected graph using bfs" + CycleUndirected(graph, V));

    }
}