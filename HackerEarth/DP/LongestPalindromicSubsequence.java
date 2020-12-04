/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/special-palindrome-3/description/?layout=old
 */

import java.io.*;
import java.util.*;
import java.lang.*;

class LongestPalindromicSubsequence implements Runnable {
	public static void main(String[] args) {
		new Thread(null, new LongestPalindromicSubsequence(), "Check", 1 << 28).start(); // to increase stack size in java
	}

	static StringBuilder out = new StringBuilder();
	static long mod = (long) 1e9 + 7;
	
	public void run() {
        int t = nextInt();
		while (t-- > 0) {
			char c = next().charAt(0);
			char[] s = next().toCharArray();
			out.append(solve(s, c, s.length) + "\n");
		}
		print(out);
		close();
	}

    static void init(char[] s, char c, int[][] cps, int[][] f, int n) {
        for(int i = 0; i < n; i++) {
            cps[i][i] = 1;
            if (s[i] == c) {
                f[i][i] = 1;
            }
        }
    }
	static int solve(char[] s, char c, int N) {
	    int[][] cps = new int[N + 1][N + 1];
	    int[][] f = new int[N + 1][N + 1];
	    init(s, c, cps, f, N);
	    
	    // Finding length of longest palindromic subsequence contains char c
	    // for recursive solution see solve method of  https://www.hackerearth.com/submission/43769531/
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i < N; i++) {
                int j = L + i - 1;
                if (j < N) {
                    if (s[i] == s[j]) {
                        cps[i][j] = cps[i+1][j-1] + 2;
                        if (s[i] == c) {
                            f[i][j] = cps[i][j];
                        }
                        else if (f[i+1][j-1] != 0) {
                            f[i][j] = f[i+1][j-1] + 2;
                        }
                    }
                    else {
                        cps[i][j] = Math.max(cps[i][j-1], cps[i+1][j]);
                        f[i][j] = Math.max(f[i][j-1], f[i+1][j]);
                    }
                }
            }
        }
       
        return f[0][N-1];
    }
    
    // Finding length of longest palindromic subsequence using recursion
    static int lps(int[] s, int[] cps, int l, int r) {
        // base cases
		if(l > r)
			return 0;
		if(cps[l][r] != -1)
			return cps[l][r];
		if(l == r)
			return cps[l][r] = 1;
		if(s[l] == s[r])	        // if both end are same
			return cps[l][r] = 2 + lps(s, cps, l+1, r-1);
		return cps[l][r] = Math.max(lps(s, cps, l, r-1), lps(s, cps, l+1, r));
	}
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
    static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}

	static class Pair {
        int x;
        int y;

        public Pair (int x, int y) {
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
            Pair pair= (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
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
	static long C(int[] fact, int n, int r) {
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
	private static InputStream stream = System.in;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;

	public static int read() {
		if (numChars == -1)
			throw new InputMismatchException();

		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}

			if (numChars<= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public static String nextLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String stock = "";
		try {
			stock = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stock;
	}

	public static int nextInt() {
		int c = read();

		while (isSpaceChar(c))
			c = read();

		int sgn = 1;

		if (c == '-') {
			sgn = -1;
			c = read();
		}

		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		while (!isSpaceChar(c));

		return res * sgn;
	}

	public static long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;

		do {
			if (c<'0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		while (!isSpaceChar(c));
		return res * sgn;
	}

	public static double nextDouble() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E')
				return res * Math.pow(10, nextInt());
			if (c<'0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c<'0' || c > '9')
					throw new InputMismatchException();
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}

	public static String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		}
		while (!isSpaceChar(c));

		return res.toString();
	}

	public static boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public static String next() {
		return readString();
	}

	public static interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
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