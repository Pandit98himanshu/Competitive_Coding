/**
 * https://www.codechef.com/LRNDSA02/problems/ZCO12002
 */




/*
                            ////////////////////////
                            /// Correct solution ///
                            ////////////////////////
// https://www.codechef.com/viewsolution/32021398
bool compare(pair<int, int> a, pair<int , int> b)
{
    return (a.second - a.first <= b.second - b.first);
}

sort(an.begin(), an.end(), compare);
sort(ax.begin(), ax.end());
sort(ay.begin(), ay.end());
int MIN = INT_MAX;
for (int i = 0; i < N; i++)
{
    if(an[i].second - an[i].first > MIN)
        break;
    int s = lower_bound(ax.begin(), ax.end(), an[i].first) - ax.begin();
    if(an[i].first != ax[s])
        s--;
    s = ax[s];
    int e = *lower_bound(ay.begin(), ay.end(), an[i].second);
    if(e < an[i].second)
        e = INT_MAX;
    if(e - s + 1 < MIN)
        MIN = e - s + 1;
}
*/

                            //////////////////////////
                            /// Incorrect solution ///
                            //////////////////////////
import java.io.*;
import java.util.*;
import java.lang.*;

class Wormholes implements Runnable {
	public static void main(String[] args) {
		new Thread(null, new Wormholes(), "Check", 1 << 28).start(); // to increase stack size in java
	}

	static long mod = (long)(1e9 + 7);
    static int MAX = (int) 1e8;
	public void run() {
        
	    int n = nextInt();
	    int x = nextInt();
	    int y = nextInt();
	    
	    int[][] contests = new int[n][2];
	    for (int i = 0; i < n; i++) {
	        contests[i][0] = nextInt();
	        contests[i][1] = nextInt();
	    }
	    
	    int[] v = new int[x];
	    for (int i = 0; i < x; i++) {
	        v[i] = nextInt();
	    }
	    
	    int[] w = new int[y];
	    for (int i = 0; i < y; i++) {
	        w[i] = nextInt();
	    }
	    
        Arrays.sort(v);
        Arrays.sort(w);
        
        int ans = MAX;
        // iterate for all contests
        for (int i = 0; i < n; i++) {
            // find lower bound for contest[i][0]
            int lb = lower_bound(v, 0, x, contests[i][0]) - 1;
            if (lb < 0) {
                lb = 0;
            }
            
            int t1 = v[lb];
            
            // find upper bound for contest[i][1]
            int ub = upper_bound(w, 0, y, contests[i][1]) - 1;
            if (ub < 0) {
                ub = 0;
            }
            
            int t2 = w[ub];
            
            // calculate (t2 - t1 + 1) and store in variable t
            int t = t2 - t1 + 1;
            if (t1 > contests[i][0] || t2 < contests[i][1]) {
                t = MAX;
            }
            // keep track of minimum t
            if (ans > t) {
                ans = t;
            }
        }
        
		print(ans);
		close();
	}
	
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
    
	static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}
	
	// finding lower bound for element “key” in a sorted array “a”
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
	
	// finding upper bound for element “key” in a sorted array “a”
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
	
    static long __gcd(long n1, long n2) { 
        long gcd = 1; 
  
        for (int i = 1; i <= n1 && i <= n2; ++i) { 
            // Checks if i is factor of both integers 
            if (n1 % i == 0 && n2 % i == 0) { 
                gcd = i; 
            } 
        } 
        return gcd; 
    }
    
	static long modinv(long a, long b, long mod) {
		long p = power(b, mod - 2, mod);

		p = a % mod * p % mod;
		p %= mod;
		return p;
	}
	
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