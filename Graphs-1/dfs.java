import java.util.*;

public class dfs{
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
    public static void dfs(ArrayList<Edge>[] graph, boolean[]visited){
        for(int i=0 ; i<graph.length ; i++){
            if(!visited[i]){
                dfsutil(graph, i, visited);
            }
        }
    }
    public static void dfsutil(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        System.out.println(curr + " ");
        visited[curr] = true;
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsutil(graph,e.dest, visited);
            }
        }
    }
    public static void main(String args[]){
        int V=7;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        //0-> vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        
        

        graph[2].add(new Edge(2,3));
        

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));


        graph[4].add(new Edge(4,5));
        

        
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

        dfs(graph, new boolean[V]);

    }
  }
