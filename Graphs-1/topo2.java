import java.util.*;

public class topo2{
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
    public static void calculate(ArrayList<Edge>[]graph, int[]incomingDegree){
        for(int i=0  ; i<graph.length ; i++){
            int v = i;
            for(int j=0 ; j<graph[v].size() ; j++){
                Edge e = graph[v].get(j);
                incomingDegree[e.dest]++;
            }
        }
    }
    public static void bfs(ArrayList<Edge>[]graph){
        int[] incomingDegree = new int[graph.length];
        calculate(graph, incomingDegree);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0  ; i<graph.length ; i++){
            if(incomingDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();

            System.out.println( curr + ",");
            for(int i=0 ; i<graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);

                incomingDegree[e.dest]--;

                if(incomingDegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String args[]){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V ; i++){
            graph[i] = new ArrayList<>();
        }
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,0));

        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,2));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        

        bfs(graph);
        

    }
}