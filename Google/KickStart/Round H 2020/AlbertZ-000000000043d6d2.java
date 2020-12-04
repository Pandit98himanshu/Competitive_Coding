import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000000+7;
    public static void main(String[] args)throws IOException {
//        String[] buf = reader.readLine().split(" ");
//        int T = Integer.parseInt(buf[0]);
        Solution sl = new Solution();
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            out.print(String.format("Case #%d: ",i));
//            out.println(sl.solve());
            sl.solve();
        }
        out.flush();
    }
    void solve() throws IOException{
        long L = sc.nextLong(), R = sc.nextLong();
        long temp1 = helper(L-1), temp2 = helper(R);
        out.println(temp2-temp1);
    }
    long helper(long n){
        if(n<=1) return n;
        if(n<=9) return (n-1)/2+1;
        int len = Long.toString(n).length();
        long ans = 0;
        for(int i=1; i<len; i++){
            int left = i/2, right = i-left;
            ans += power(5,left)*power(5,right);
        }
        char[] arr = Long.toString(n).toCharArray();
        for(int j=1; j<=arr[0]-'0'; j+=2){
            int left = (len-1)/2, right = len-1-left;
            if(j<arr[0]-'0') ans += power(5,left)*power(5, right);
            else ans += dfs(len, arr, 1);
        }
        return ans;
    }
    long dfs(int len, char[] arr, int pos){
        if(pos==len) return 1;
        long ans = 0;
        int upper = arr[pos]-'0';
        for(int j=0; j<=upper; j++){
            if(j%2!=pos%2){
                if(j<upper){
                    int remain = len-pos-1;
                    ans += power(5, remain/2)*power(5, remain-remain/2);
                } else{
                    ans += dfs(len,arr, pos+1);
                }
            }
        }
        return ans;
    }
    long power(long base, long p){
        if(p<0) return 0;
        if(p==0) return 1;
        return (long)Math.pow(base,p);
    }

}
