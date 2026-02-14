import java.util.*;

public class bipart{
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

    public static boolean bipartitie(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<graph.length ; i++){
            if(color[i] == -1){
                q.add(i);
                color[i]=0;

                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0 ; j<graph[curr].size() ; j++){
                      Edge e = graph[curr].get(j);

                      //case 3 no color
                      if(color[e.dest]==-1){
                        int nextColor = color[curr] == 0 ? 1 : 0;
                        color[e.dest] = nextColor;
                        q.add(e.dest);
                      }else if(color[e.dest] == color[curr]) return false;
                    }
                }
            }
        }
        return true;
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

        System.out.println(bipartitie(graph));
    }
}