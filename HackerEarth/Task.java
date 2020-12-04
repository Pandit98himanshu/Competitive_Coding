import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.*;
/**
 * https://www.hackerearth.com/practice/math/combinatorics/inclusion-exclusion/practice-problems/algorithm/easy-one-4/
 */

class Task implements Runnable {
	public static void main(String[] args) {
		new Thread(null, new Task(), "Check", 1 << 28).start(); // to increase stack size in java
	}

	static long mod = (long) (1e9 + 7);
	static int MAX = (int) (1e5 + 10);
	static long[] fact = new long[MAX + 1];
	static boolean[] prime = new boolean[MAX + 1];
	
	public void run() {
	    StringBuilder ans = new StringBuilder();
	    int t = nextInt();
	    while (t-- > 0) {
            long n = nextLong();
            int p = nextInt();
            int[] arr = new int[p];
            for (int i = 0; i < p; i++) {
                arr[i] = nextInt();
            }
            int[] a = IntStream.of(arr).distinct().toArray();
            p = a.length;
            // directly use inclusion-exclusion principle and get answer
            long powerSetSize = (1 << p);
            long odd = 0, even = 0;
            for (long i = 1; i < powerSetSize; i++) {
                long temp = 1, sign = -1;
                for (int j = 0; j < p; j++) {
                    if ((i & (1 << j)) > 0) {
                        temp *= a[j];
                        sign *= -1;
                    }
                }
                
                if (sign == 1) {
                    odd += n/temp;
                }
                else {
                    even += n/temp;
                }
                
            }
		    ans.append(odd - even + "\n");
		}
		print(ans);
		close();
	}
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
    
	static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}
	// calculates x!
	static void factorial(long[] fact, int n, long mod) {
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
	// returns (1/x) % (10^9 + 7)
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
	int factmod (int n, int p) {
		int res = 1;
		while (n > 1) {
			res = (res * ((n/p) % 2 == 0 ? p-1 : 1)) % p;
			for (int i = 2; i <= n % p; ++i)
				res = (res * i) % p;
			n /= p;
		}
		return res % p;
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