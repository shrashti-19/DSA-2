import java.util.*;

public class cycle2{
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
    public static boolean cycleExists(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0 ; i<graph.length ; i++){
            if(!visited[i]){
                if(cycleExistsUtil(graph,i,visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleExistsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack){
        visited[curr] = true;
        stack[curr] = true;
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]==true){
                return true;
            }
            if(!visited[e.dest] && cycleExistsUtil(graph, e.dest, visited, stack)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        //0-> vertex
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));

        System.out.println(cycleExists(graph));
    }
}