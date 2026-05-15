class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // as edges are given we have to build
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
          graph[i] = new ArrayList<>();  
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination){
                return true;
            }else{
                for(int i=0 ; i<graph[node].size() ; i++){
                    int neighbor = graph[node].get(i);
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
        }
        return false;
    }
}