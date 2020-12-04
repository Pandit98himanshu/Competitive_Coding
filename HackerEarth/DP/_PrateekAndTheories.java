import java.io.*;
import java.util.*;
import java.lang.*;

class _PrateekAndTheories {

	static StringBuilder out = new StringBuilder();
	static long mod = (long) (1e9 + 7);
	static int MAX = (int) (1e6);
	static long[] fact = new long[MAX + 1];
	static boolean[] prime = new boolean[MAX + 1];
	
	public static void main(String[] args) throws IOException {
        int t = nextInt();
        int ans = 0, count = 0;
		while (t-- > 0) {
			int n = nextInt();
            Vector<Pair> v = new Vector<>();
            for (int i = 0; i < n; i++) {
                v.add(new Pair(nextInt(), 'x'));
                v.add(new Pair(nextInt(), 'y'));
            }
            
			Collections.sort(v, new Comparator<Pair>() {
			    @Override
			    public int compare(final Pair o1, final Pair o2) {
			        if (o1.first < o2.first) {
			            return -1;
			        }
			        else if (o1.first > o2.first) {
			            return 1;
			        }
			        return 0;
			    }
			});
			
			println(v);
			
			for (int i = 0; i < v.size(); i++) {
			    if (v.get(i).second == 'x') {
			        count++;
			    }
			    if (v.get(i).second == 'y') {
			        count--;
			    }
			    ans = Math.max(ans, count);
			}

			out.append(ans + "\n");
		}
		print(out);
		close();
	}
	
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
    static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}

	static class Pair {
        int first;
        char second;

        public Pair (int first, char second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
        /*
        @Override
        public int compareTo(Object o) {
            if (o instanceof Pair) {
                Pair pair = (Pair) o;
                if (first > pair.first) {
                    return 1;
                }
                else if (first < pair.first) {
                    return -1;
                }
                return 0;
            }
            return 0;
        }
        */
    }
	// calculates x!
	static void factorial(long[] fact, int n) {
		fact[0] = 1;
		for(int i = 1; i < n; i++) {
			fact[i] = (i * fact[i-1]) % mod;
		}
	}
	// finding lower bound for element "key" in a sorted array "a" from index "low" to "high" - 1
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
	// finding upper bound for element "key" in a sorted array "a" from index "low" to "high" - 1
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
	static long C(int n, int r) {
		long result = (fact[n] * modInv(fact[r], mod)) % mod;
		result = (result * modInv(fact[n - r], mod)) % mod;
		return result;
	}
	// Greatest Common Divisor or, Highest Common Factor
	static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	static void smallestPrimeFactor(int[] spf, int n) {
        for(int i = 0; i <= n; i++) {
			spf[i] = i;
		}
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i + i; j <= n; j += i) {
					if (spf[j] == j) {
						spf[j] = i;
					}
                }
            }
        }
    }
	// Sieve of Eratosthenes
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
	// Finds the number of positive integers <= n that are coprime to n.
    // Time Complexity : O(nloglogn)
    static int[] eulerTotient(int n) {
        int[] phi = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            phi[i] = i;
        }
        
        for (int i = 2; i <= n; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= n; j+= i) {
                    phi[j] -= phi[j] / i;
                }
            }
        }
		return phi;
    }
	// src : http://e-maxx.ru/algo/modular_factorial
	// Time Complexity : O(p log_p n)
	int factmod(int n, int p) {
		int res = 1;
		while (n > 1) {
			res = (res * ((n/p) % 2 == 0 ? p-1 : 1)) % p;
			for (int i = 2; i <= n % p; ++i)
				res = (res * i) % p;
			n /= p;
		}
		return res % p;
	}
	// Fastest way to calculate fibonacci value of n
	// src : https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
	static long fib(long n) { 
		long F[][] = new long[][]{{1,1},{1,0}}; 
		if (n == 0)
			return 1; 
		power(F, n-1); 
	
		return F[0][0]; 
    }
	static void power(long F[][], long n) { 
		if (n == 0 || n == 1)
			return;
		long M[][] = new long[][]{{1,1},{1,0}}; 
		
		power(F, n/2); 
		multiply(F, F); 
		
		if (n%2 != 0) 
			multiply(F, M); 
    }
    static void multiply(long F[][], long M[][]) { 
		long x =  (F[0][0]*M[0][0] % mod + F[0][1]*M[1][0] % mod) % mod; 
		long y =  (F[0][0]*M[0][1] % mod + F[0][1]*M[1][1] % mod) % mod; 
		long z =  (F[1][0]*M[0][0] % mod + F[1][1]*M[1][0] % mod) % mod; 
		long w =  (F[1][0]*M[0][1] % mod + F[1][1]*M[1][1] % mod) % mod; 
		
		F[0][0] = x; 
		F[0][1] = y; 
		F[1][0] = z; 
		F[1][1] = w; 
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

/*~~~~~~~~~~~~~~~~~    FAST OUTPUT METHODS    ~~~~~~~~~~~~~~~~~*/
	private static final PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
			}
            writer.print(objects[i]);
        }
    }

    public static void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public static void close() {
        writer.close();
    }

    public static void flush() {
        writer.flush();
    }
}