public class province{
    public static int findProvince(int[][]isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count=0;
        for(int i=0 ; i<n ; i++){
            if(!visited[i]){
                count++;
                dfsUtil(isConnected,visited,i);
            }
        }
        return count;
    }

    public static void dfsUtil(int[][]isConnected, boolean[]visited, int curr){
        visited[curr] = true;
        for(int j=0 ; j<isConnected.length ; j++){
            if(isConnected[curr][j]==1 && !visited[j]){
                dfsUtil(isConnected, visited, j);
            }
        }
    }
    public static void main(String[] args) {
        int isConnected[][] = {{1,1,0},
        {1,1,0},
        {0,0,1}};

        System.out.println("The total number of provinces: " + findProvince(isConnected));
    }
}