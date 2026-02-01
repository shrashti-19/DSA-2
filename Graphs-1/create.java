import java.util.*;

public class create{
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.wt = weight;
        }

    }
    public static void main(String args[]){
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        //0-> vertex
        graph[0].add(new Edge(0,1,5));
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,3));

        graph[4].add(new Edge(4,2,2));


        //2's neighbor
        for(int i=0 ; i<graph[2].size() ; i++){
            Edge e = graph[2].get(i); //src,dest,wt
            System.out.println(e.dest);
        }
    }
}