public class flood {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor = image[sr][sc];

        if(originalcolor == color){
            return image;
        }


        int n = image.length;
        int m = image[0].length;

        dfs(image, originalcolor, color, sr,sc);
        return image;
    }
    public static void dfs(int[][]image, int originalcolor, int color, int sr, int sc){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=originalcolor){
            return;
        }
        image[sr][sc] = color;
        dfs(image, originalcolor, color, sr-1, sc);
        dfs(image, originalcolor, color, sr+1,sc);
        dfs(image, originalcolor, color, sr, sc+1);
        dfs(image, originalcolor, color, sr, sc-1);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int  sr = 1, sc = 1, color = 2;
        int[][] result = floodFill(image, sr, sc, color);
        for(int i=0 ; i<result.length ;  i++){
            for(int j=0 ; j<result.length ; j++){
                System.out.print(result[i][j] + ",");
            }
            System.out.println("");
        }
    }
}