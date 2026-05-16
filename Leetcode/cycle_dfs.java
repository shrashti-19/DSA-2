import java.util.*;

public class cycle_dfs{
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean dfsCycle(ArrayList<Edge>[]graph, int V){
        boolean[] visited = new boolean[V];
        for(int i=0 ; i<V ; i++){
            if(!visited[i]){
                if(dfsCycleUtil(graph,visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsCycleUtil(ArrayList<Edge>[] graph, boolean[]visited, int curr, int parent){
        visited[curr] = true;

        for(int i=0 ;  i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                if(dfsCycleUtil(graph, visited, e.dest, curr)){
                    return true;
                }
            }else if(e.dest!=parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0 ; i<V ; i++){
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

        System.out.println("DFS cycle : "  + dfsCycle(graph, V));
    }
}