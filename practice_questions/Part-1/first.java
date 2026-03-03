import java.util.*;

public class first{
    static class Edge{
        int src;
        int dest;
        //int wt;

        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
            //this.wt = weight;
        }

    }
    public static boolean cycleusingBFS(ArrayList<Edge>[]graph, int src){
        boolean[] visited = new boolean[graph.length];
        

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (cycleusingBFSUtil(graph, visited, i)) {
                    return true;
                }
            }
        }
        return false;
        
    }

    public static boolean cycleusingBFSUtil(ArrayList<Edge>[]graph,boolean[]visited,int src){
        Queue<int[]> q = new LinkedList<>();
        visited[src] = true;
        q.add(new int[]{src,-1});
        while(!q.isEmpty()){
            int pair[] = q.remove();
            int curr = pair[0];
            int parent = pair[1];

            for(Edge e : graph[curr]){
                int neighbor = e.dest;

                //if neighbour is not visited then visit and add into queue
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(new int[]{neighbor,curr});
                }else if(neighbor!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        //0-> vertex
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));

        int src = 0;

        System.out.println("Cycle exists or not using BFS "+cycleusingBFS(graph,src));

       

    }
}