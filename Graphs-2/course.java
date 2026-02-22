import java.util.*;

public class course{
    public static int[] courseSchedule(int numCourses, int[][] prequisites){
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
           graph[i] = new ArrayList<>();
        }

        int[] incoming = new int[graph.length];
        for(int i=0 ; i<prequisites.length ; i++){
            int a = prequisites[i][0];
            int b = prequisites[i][1];
            graph[b].add(a);
            incoming[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        int index  = 0;
        for(int i=0 ; i<incoming.length ; i++){
            if(incoming[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            result[index++] = curr;

           for(int neighbour : graph[curr]){
             incoming[neighbour]--;
             if(incoming[neighbour]==0){
                q.add(neighbour);
             }
             
           }

        }
        if(index!=numCourses){
            return new int[0];
        }
        return result;
    }
    public static void main(String args[]){
        int numCourses = 2;
        int[][] prequisites = {{1,0}};
        int ans[] = courseSchedule(numCourses, prequisites);
        for(int i=0 ; i<ans.length ; i++){
            System.out.print(ans[i] + ",");
        }
    }
}