import java.io.*;
import java.util.*;


public class TestClass {
    static boolean[] visited = new boolean[1000005];
    public static void main(String[] args) throws IOException {
     Scanner in = new Scanner(System.in);
        
         int n = in.nextInt();
         int k = in.nextInt();
         in.nextLine();
         int[][] edges = new int[n-1][2];
         for(int i_edges=0; i_edges<n-1; i_edges++)
         {
         	
         	for(int j_edges=0; j_edges<2; j_edges++)
         	{
         		edges[i_edges][j_edges] = in.nextInt() - 1;
         	}
         }
         

         int[] thieves = new int[k];
         for(int i_thieves=0; i_thieves<k; i_thieves++)
         {
         	thieves[i_thieves] = in.nextInt() - 1;
         }

         int out_ = Solution(thieves, edges,n,k);
         System.out.println(out_);
    }
    static int Solution(int[] thieves, int[][] edges,int n,int k){
        /*
        // make 0-indexing
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                edges[i][j]--;
            }
        }
        for(int i = 0; i < k; i++) {
            thieves[i]--;
        }
        */
        // create empty map of n cities
        int[][] map = new int[n][n];
        // initialize map
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = 0;
            }
        }
        for(int i = 0; i < n-1; i++) {
            map[edges[i][0]][edges[i][1]]++;
            map[edges[i][1]][edges[i][0]]++;
        }
        // we can't reach cities having thieves
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++) {
                map[j][thieves[i]] = 0;
                map[thieves[i]][j] = 0;
            }
        }
        // visit cities having no trees
        java.util.Arrays.fill(visited, false);
        visited[0] = true;      // we're already at city 0
        for(int i = 1; i < n; i++) {
            if(map[0][i] != 0) {
                goToCity(i, map, n);
            }
        }
        // see which cities we can visit
        int visitedCities = 0;
        for(boolean yes : visited) {
            if (yes) {
                visitedCities++;
            }
        }
        return visitedCities - 1;       // removing starting city i.e., city 0
    }
    static void goToCity(int i, int[][] map, int n) {
        visited[i] = true;
        /*
        // check whether we can visit any other city city i or not
        int count = 0;
        for(int j = 1; j < n; j++) {
            if(i != j && map[i][j] == 1 && !visited[i]) {
                count++;
            }
        }
        if(count == 0) {
            return;
        }
        */
        for (int j = 1; j < n; j++) {
            if(i != j && map[i][j] == 1 && !visited[j]) {
                goToCity(j, map, n);
            }
        }
    }
}