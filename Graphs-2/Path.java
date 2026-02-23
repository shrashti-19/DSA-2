import java.util.*;

public class Path{
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

    public static void printAllPaths(ArrayList<Edge>[]graph, int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
        }

        for(int i=0 ; i<graph[src].size() ; i++){
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+src);
        }
    }
    public static void main(String[] args) {
         int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,0));

        graph[0].add(new Edge(0,3));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        printAllPaths(graph,5,1,"");
        
    }
}