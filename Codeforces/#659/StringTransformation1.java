import java.io.*;
import java.util.*;
import java.lang.*;

public class StringTransformation1 {
	
	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			char[] a = in.next().toCharArray();
			char[] b = in.next().toCharArray();

			boolean flag = true;
			for (int i = 0; i < n; i++) {
				if (b[i] - a[i] < 0) {
					out.println(-1);
					flag = false;
					break;
				}
			}
			if (flag) {
				int ans = 0;
								////////////////////
								/// WRONG ANSWER ///
								////////////////////
				HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
				for (int i = 0; i < n; i++) {
					if (b[i] - a[i] > 0) {
						//Pair p = new Pair(a[i], b[i]);
						//hash.put(p, hash.getOrDefault(p, 0) + 1);
						hash.put(a[i], hash.getOrDefault(a[i], 0) + 1);
					}
				}
				ans = hash.size();
				out.println(ans);
				out.println(" : " + hash);
				/*
								//////////////////////
								/// CORRECT ANSWER ///
								//////////////////////
				for(char c = 'a'; c <= 't'; c++) {
					char minbc = 'z';
					for(int i = 0; i < n; i++) {
						if(a[i] == c && b[i] > c) {
							minbc = (char) Math.min(minbc, b[i]);
						}
					}

					if(minbc != 'z' && minbc != c) {
						for(int i = 0; i < n; i++) {
							if(a[i] == c && b[i] > c) {
								a[i] = minbc;
							}
						}
						ans++;
					}
				}
				out.println(ans);
				String tempA = new String(a);
				String tempB = new String(b);
				if (!tempA.equals(tempB))
					//out.println(" -> " + tempA + " : " + tempB);
				

								//////////////////////
								/// CORRECT ANSWER ///
								//////////////////////
				for (int t = 0; t < cases; t++) {
					int n = in.nextInt();
					String a = in.next();
					String b = in.next();
					boolean done = false;
					HashSet set[] = new HashSet[20];
					Arrays.setAll(set , x -> new HashSet<Integer>());
					for(int i = 0; i < n; i++){
						if(a.charAt(i) != b.charAt(i)){
							if(a.charAt(i) > b.charAt(i)){
								out.println(-1); 
								done = true; 
								break;
							}
							set[a.charAt(i) - 'a'].add(b.charAt(i) - 'a');
						}
					}
					if (done)
						continue;
					int ans = 0;
					for (int i = 0; i < 20; i++){
						HashSet<Integer> s = (HashSet<Integer>)set[i];
						if (set[i].size() == 0)
							continue;
						int mn = min(s); 
						ans++; 
						s.remove(mn);
						set[mn].addAll(s);
					}
					out.println(ans);
				}
				*/
			}			
		}
        out.close();
	}

	static class Pair {
        char x;
        char y;

        public Pair (char x, char y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = (result * PRIME) + this.x;
            result = (result * PRIME) + this.y;
            return result;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

}	

/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
class Utilities {
	static long mod = (long) (1e9 + 7);

    static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}
	
	static void factorial(long[] fact, int n) {
		fact[0] = 1;
		for(int i = 1; i < n; i++) {
			fact[i] = (i * fact[i-1]) % mod;
		}
	}
	
	static int lower_bound(int[] a, int low, int high, int key) {
	    while (low < high) {
	        int mid = low + ((high - low) >> 1);
	        if (a[mid] >= key) {
	            high = mid;
	        }
	        else {
	            low = mid + 1;
	        }
	    }
	    return low;
	}

	static int upper_bound(int[] a, int low, int high, int key) {
	    while (low < high) {
	        int mid = low + ((high - low) >> 1);
	        if (a[mid] <= key) {
	            low = mid + 1;
	        }
	        else {
	            high = mid;
	        }
	    }
	    return low;
	}

	// returns (x ^ y) % mod
	static long power(long x, long y, long mod) {
		if (y == 0) return 1 % mod;
		if (y == 1) return x % mod;
		long res = 1;
		x = x % mod;
		while (y > 0) {
			if ((y & 1) == 1) {
				res = (res * x) % mod;
			}
			y = y >> 1;
			x = (x * x) % mod;
		}
		return res;
	}
	// returns (1/a) % (10^9 + 7)
	static long modInv(long x, long mod) {
		return power(x, mod - 2, mod);
	}

	// returns value of nCr
	static long C(long[] fact, long n, long r, long mod) {
		long result = (fact[(int) n] * modInv(fact[(int) r], mod)) % mod;
		result = (result * modInv(fact[(int) (n - r)], mod)) % mod;
		return result;
	}

	static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	// Finding Smallest Prime Factor has similar implementation as sieve
	static void sieve(boolean[] prime, int n) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
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


