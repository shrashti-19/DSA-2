import java.util.*;

public class cycle{
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

    public static boolean detectCyleUtil(ArrayList<Edge>[]graph, boolean visited[], int curr, int parent){
        visited[curr] = true;
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            //case 3
            if(!visited[e.dest]){
                if(detectCyleUtil(graph, visited, e.dest, curr)){
                    return true;
                }
                //case1
            }else if(visited[e.dest] && e.dest!=parent){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if(!visited[i]){
                if(detectCyleUtil(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
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

        System.out.println(detectCycle(graph));
    }
}