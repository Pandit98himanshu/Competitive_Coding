import java.io.*;
import java.util.*;
import java.lang.*;

class SpecialNumbers {
	static int[] digits = { 4, 7 };	
	static TreeSet<Integer> numbers = new TreeSet<>();
	static {
		for (int i = 1; i <= 9; i++) {
			rec(0, i);
		}
	}
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		Object[] nums = numbers.toArray();

		int n = in.nextInt();
		int ind;
		for (ind = 0; ind < nums.length; ) {
			int val = (Integer) nums[ind];
			if (val == n) {
				break;
			}
			else if (val > n) {
				ind--;
				break;
			}
			else if (val < n) {
				ind++;
			}
			// System.out.println(nums[ind]);
		}

		int count = 0;
		if (ind == nums.length) {
			ind--;
		}
		for (int i = 0; i <= ind; i++) {
			int a = (Integer) nums[i];
			for (int j = i + 1; j <= ind; j++) {
				int b = (Integer) nums[j];
				if (gcd(a, b) == 1) {
					out.println(a + ", " + b);
					count++;
				}
			}
		}
		out.print(count);
		out.close();
	}
	static void rec(int current, int n) {
		if (n == 0) {
			numbers.add(current);
		}
		else {
			for (int x : digits) {
				rec(current * 10 + x, n - 1);
			}
		}
	}
	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
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
	static long[] nextLongArray(int n) throws IOException {
		long a[] = new long[n];
		for(int i = 0; i < n; i++)
			a[i] = nextLong();
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


