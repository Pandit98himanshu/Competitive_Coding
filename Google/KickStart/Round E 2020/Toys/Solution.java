import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int t = in.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = in.nextInt();
/*
			int[][] a = new int[n][2];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				a[i][0] = in.nextInt();
				a[i][1] = in.nextInt();
				sum += a[i][0];
			}

			boolean indefinite = true;
			long sumI2 = 0;
			for (int i = 0; i < n; i++) {
				if ((a[i][1] + a[i][0] - sumI1 <= 0) {
					sumI2 += a[i][0];
				}
				else {
					indefinite = false;
					break;
				}
			}
			
			String totalTime = "";
			if (indefinite) {
				totalTime = "INDEFINITELY";
			}
			else {
				totalTime = Long.toString(sumI1 + sumI2);
			}

			// printing results
			out.print("Case #" + tc + ":");
			out.println(totalTime);
*/
/*
			PriorityQueue<Pair> a = new PriorityQueue<Pair>(new Comparator<Pair>() {
				public int compare(Pair p1, Pair p2) {
					if ((p1.e + p1.r) < (p2.e + p2.r)) return 1;
					if ((p1.e + p1.r) < (p2.e + p2.r)) return 0;
					return -1;
				}
			});

			int r = 0, e = 0, sum = 0;
			for (int i = 0; i < n; i++) {
				e = in.nextInt();
				r = in.nextint();
				sum += e;
				a.add(new Pair(e, r));
			}
*/

	// Correct Solution :– https://clist.by/solutions/23847341/00000000003bede9/
			int[] E = new int[N];
			int[] R = new int[N];
			long tot = 0;
			for (int i = 0; i < N; i++) {
				E[i] = in.nextInt();
				R[i] = in.nextInt();
				tot += E[i];
			}

			long fin = tot, sTot = 0, cur = tot;
			int c = 0, save = 0;
			PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

				public int compare(Integer integer, Integer t1) {
					return Integer.compare(E[t1] + R[t1], E[integer] + R[integer]);
				}
			});
			for (int i = 0; i < N; i++) {
				sTot += E[i];
				queue.add(i);
				while (queue.size() > 0 && E[queue.peek()] + R[queue.peek()] > cur) {
					int next = queue.remove();
					sTot -= E[next];
					cur -= E[next];
					c++;
				}
				if (sTot + cur > fin) {
					fin = sTot + cur;
					save = c;
				}
			}
			String res;
			if (queue.size() == 0) {
				res = save + " " + Long.toString(fin);
			} else {
				res = c + " INDEFINITELY";
			}
		}
        out.close();
	}

	static class Pair {
		int e;
		int r;

		public Pair (int e, int r) {
			this.e = e;
			this.r = r;
		}
		@Override
		public int hashCode() {
			final int PRIME = 59;
			int result = 1;
			result = (result * PRIME) + this.e;
			result = (result * PRIME) + this.r;
			return result;
		}
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair pair= (Pair) o;
			return e == pair.e && r == pair.r;
		}
		@Override
		public String toString() {
			return "(" + e + ", " + r + ")";
		}
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


