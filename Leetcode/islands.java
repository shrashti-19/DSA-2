public class islands{
     public static int numIslands(char[][] grid) {
        int n = grid.length;//rows
        int m = grid[0].length; //cols
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfsUtil(grid, visited, i,j);
                }
            }
        }
        return count;
    }
    public static void dfsUtil(char [][]grid, boolean[][]visited, int row, int col){
        //base condition
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length 
   || visited[row][col] || grid[row][col] == '0') {
    return;
         }

        visited[row][col] = true;

        //traverse in 4 directions
        dfsUtil(grid, visited, row-1,col);
        dfsUtil(grid,visited, row+1,col);
        dfsUtil(grid, visited, row, col+1);
        dfsUtil(grid, visited, row, col-1);

    }

    public static void main(String[] args) {

        char grid[][] = {
    {'1','1','1','1','0'},
    {'1','1','0','1','0'},
    {'1','1','0','0','0'},
    {'0','0','0','0','0'}
};

        System.out.println("Number of islands: " + numIslands(grid));
    }
}