import java.util.*;
public class rotten{
    public static int orangesRotting(int[][] grid) {
        int n = grid.length; //rows
        int m = grid[0].length; //columns

        Queue<int[]> q = new LinkedList<>(); // row, col stored
        int fresh = 0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==2){
                    //push into queue
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        //edge case
        if(fresh==0){
            return 0; //already rotten
        }

        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0 ; i<size ; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                //up
                if(r-1>=0 && grid[r-1][c]==1){
                    grid[r-1][c] = 2;
                    fresh--;
                    q.add(new int[]{r-1,c});
                }

                //down
                if(r+1<n && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    fresh--;
                    q.add(new int[]{r+1,c});
                }

                //left
                if(c-1>=0 && grid[r][c-1]==1){
                    grid[r][c-1]=2;
                    fresh--;
                    q.add(new int[]{r,c-1});
                }

                //right
                if(c+1<m && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    fresh--;
                    q.add(new int[]{r,c+1});
                }

                

            }
            if(!q.isEmpty()) minutes++;
        }
        if(fresh==0) return minutes;
        return -1;
    }


    public static void main(String args[]){
        int[][] grid = {{2,1,1},
        {1,1,0},
        {0,1,1}};

        System.out.println("Minimum number of minutes: " + orangesRotting(grid));
    }
}