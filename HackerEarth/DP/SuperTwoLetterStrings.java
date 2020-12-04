/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/super-two-letter-strings/
 */

import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * general form of https://codeforces.com/blog/entry/75429
 * related question : https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/coin-toss/editorial/?layout=old
 */

class SuperTwoLetterStrings {

	static StringBuilder out = new StringBuilder();
	static long mod = (long) (1e9 + 7);
	static int size = (int) 1e4;
	static long[] pow2 = new long[size + 1];
	
	public static void main(String[] args) throws IOException {
	    powerOf2(pow2, size, mod);
        int t = nextInt();
		while (t-- > 0) {
			int n = nextInt();
            int p = nextInt();
            
            long ans = solve(n - 1, p, mod);
			out.append(ans).append("\n");
		}
		System.out.print(out);
	}
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
    static void powerOf2(long[] arr, int n, long mod) {
		arr[0] = 1;
		for (int i = 1; i <= n; i++) {
		    arr[i] = (arr[i - 1] << 1) % mod;
		}
	}

    static long solve(int n, int p, long mod) {
        long[] dp = new long[n + 1];
        for (int i = 0; i < p; i++) {
            dp[i] = pow2[i];
        }
        for (int i = p; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                dp[i] += dp[i - j];
                dp[i] %= mod;
            }
        }
        return dp[n];
    }
    
/*~~~~~~~~~~~~~~~~~    FAST INPUT METHODS    ~~~~~~~~~~~~~~~~~*/
    final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
 
	static String nextLine() throws IOException {
		int c = read();
		while(isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while(!isEndOfLine(c));
		return res.toString();
	}
	static String next() throws IOException {
		int c = read();
		while(isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while(!isSpaceChar(c));
		return res.toString();
	}
	static int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	static int[] nextIntArray(int n) throws IOException {
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
	static int[][] next2dIntArray(int n, int m) throws IOException {
		int a[][] = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				a[i][j] = nextInt();
		return a;
	}
	static long[] nextLongArray(int n) throws IOException {
		long a[] = new long[n];
		for(int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}
	static char nextChar() throws IOException {
		return next().charAt(0);
	}
	static long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	static double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (c == '.') {
			while((c = read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}
		if(neg)
			return -ret;
		return ret;
	}
	static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if(bytesRead == -1)
			buffer[0] = -1;
	}
	static byte read() throws IOException {
		if(bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
	static void closeReader() throws IOException {
		if(din == null)
			return;
		din.close();
	}
	static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	private static boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
}