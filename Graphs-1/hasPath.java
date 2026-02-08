import java.util.*;

public class hasPath{
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
    public static boolean hasPath(ArrayList<Edge>[]graph, int src, int dest, boolean[]visited){
        if(src==dest)return true;
        visited[src] = true;

        for(int i=0 ; i<graph[src].size() ; i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        //0-> vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        

        graph[2].add(new Edge(2,4));
        

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));


        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

        System.out.println("The path exists between src and dest " + hasPath(graph, 0,0,new boolean[V]));

        

    }
}