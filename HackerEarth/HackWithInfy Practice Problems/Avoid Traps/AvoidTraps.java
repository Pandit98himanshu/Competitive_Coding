import java.io.*;
import java.util.*;

/////////////////////////
// Giving Wrong Answer //
/////////////////////////

class AvoidTraps {
    static int numPrimesUptoi(int n) {
        return (int)(n/Math.log(n));
    }
    static int steps = 0;
    static boolean reached = false;
    static boolean minJumps(int r1, int r2, String path, int n, int i) {
        if(i == n) {
            System.out.println(steps);
            steps = 0;
            reached = true;
            return true;
        }
        if(i > n || (path.charAt(i) == '*')) {
            return false;
        }
        steps++;
        int a = numPrimesUptoi(i);
        try {
            if(a/i >= r1/r2) {
                return minJumps(r1, r2, path, n, i + 1) ||
                    minJumps(r1, r2, path, n, i + 2) ||
                    minJumps(r1, r2, path, n, i + a);
            }
        } catch (ArithmeticException ax) {}
        
        return minJumps(r1, r2, path, n, i + 1) ||
            minJumps(r1, r2, path, n, i + 2);
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] r = br.readLine().split(" ");
            int r1 = Integer.parseInt(r[0]);
            int r2 = Integer.parseInt(r[1]);
            int n = Integer.parseInt(br.readLine());
            String path = br.readLine();

            minJumps(r1, r2, path, n, 0);
            if(reached) {
                System.out.println("No way!");
            }
        }
    }
}