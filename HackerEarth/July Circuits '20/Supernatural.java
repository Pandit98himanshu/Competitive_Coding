/**
 * https://www.hackerearth.com/challenges/competitive/july-circuits-20/algorithm/supernatural-cac54bc7/
 */

import java.io.*;
import java.util.*;
import java.lang.*;

class Solve {
	public static void solver() throws IOException {
		FastReader in = new FastReader();
		StringBuilder ans = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			
			boolean[] facts = new boolean[10];
			for (int i = 2; i < 10; i++) {
				if (n % i == 0) {
					facts[i] = true;
				}
			}

			
			System.out.println(findDivisors(n, new StringBuilder()));
		}
	}

	static StringBuilder findDivisors(int num, StringBuilder res) {
		if (num == 0) {
			res.append("\n");
			return res;
		}
		for (int j = 2; j < 10; j++) {
			int n = num;
			if (num % j == 0) {
				for (int i = j; i < 10; i++) {
					if (num % i == 0) {
						res.append(i);
						num /= i;
						i--;
						//return findDivisors(num / i, res);
					}
				}
				res.append("\n");
			}
		}
		return res;
	}
}

/*~~~~~~~~~~~~~~~~~    FAST INPUT METHODS    ~~~~~~~~~~~~~~~~~*/
class FastReader {
    final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din;
	private static byte[] buffer;
	private static int bufferPointer = 0, bytesRead = 0;
 
	public FastReader () {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
	}
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

class Supernatural {
	public static void main(String[] args) throws IOException {
		new Solve().solver();
	} 
}

