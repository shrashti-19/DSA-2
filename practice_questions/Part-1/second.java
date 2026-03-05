// have to find minimum depth of binary tree
import java.util.*;
public class second{
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

    public static int findingDepth(ArrayList<Edge>[]graph, int src){
        int level = 1;
        boolean[] visited = new boolean[graph.length];

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0 ; i<size ; i++){
                int curr = q.remove();
                boolean leaf = true;
                for(int j=0 ; j<graph[curr].size() ; j++){
                    Edge e = graph[curr].get(j);
                    if(!visited[e.dest]){
                        leaf = false;
                        visited[e.dest] = true;
                        q.add(e.dest);
                    }
                }
                if(leaf){
                    return level;
                }

            }
            level++;

        }
        return level;

    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V]; //null  -> empty arraylist
        for(int i=0 ; i<V;  i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 5));
        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5,2));
        int src = 0;

        System.out.println("Depth of the tree : " + findingDepth(graph,src));
    }
}