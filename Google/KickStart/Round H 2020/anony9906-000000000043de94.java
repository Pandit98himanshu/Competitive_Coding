import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prem_cse
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        KickStart solver = new KickStart();
        solver.solve(1, in, out);
        out.close();
    }

    static class KickStart {
     

        public void solve(int testcase, FastReader sc, PrintWriter out) {
           
        	int T = sc.nextInt();
        	for(int t=1;t<=T;++t) {
        		long l = sc.nextLong()-1;
        		long r = sc.nextLong();
        		char[] a = String.valueOf(l).toCharArray();
        		char[] b = String.valueOf(r).toCharArray();
        		long ans = solve(b) - solve(a);
        		out.println("Case #"+t+": "+ans);
        	}
        }

        char[] s;
        long[][][][] dp;
        
		private long solve(char[] b) {
			s = b.clone();
			dp = new long[20][2][2][2];
			for(int i=0;i<dp.length;++i)
				for(int j=0;j<dp[i].length;++j)
					for(int k=0;k<dp[i][j].length;++k)
						Arrays.fill(dp[i][j][k], -1);
			return f(0,1,1,0);
		}

		private long f(int i, int len, int tight, int st) {
			if(i == s.length) return 1;
			if(dp[i][len][tight][st] != -1) return dp[i][len][tight][st];
			
			long o1 = 0;
			int en = tight==1?(s[i]-'0'):9;
			
			if(st == 0) {
				o1 += f(i+1,len,tight&((s[i] == '0')?1:0),st); // not start
				for(int dig=1;dig<=en;++dig) 
					if(dig%2 == len)
					o1+=f(i+1,len^1,tight&(dig==en?1:0),1); // start
			}else {
				for(int dig=0;dig<=en;++dig) {
					if(dig%2 == len)
					o1+=f(i+1,len^1,tight&(dig==en?1:0),1);
				}
			}
			
			return dp[i][len][tight][st] = o1;
			
		}

       

    }

    static class FastReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

