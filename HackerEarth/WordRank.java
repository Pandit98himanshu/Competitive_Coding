import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Given rank of a word with given sequence of characters. Find the word at specified rank.
 * https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/word-rank-1/
 */
 
class WordRank implements Runnable {
	public static void main(String...args) {
		new Thread(null, new WordRank(), "Check2", 1 << 28).start(); // to increase stack size in java
	}

	static long mod = (long)(1e9 + 7);

	static void findFact(long[] fact, int n) {
	    fact[0] = 1;
	    for (int i = 1; i < n; i++) {
	        fact[i] = i * fact[i - 1];
	    }
	}
	
	public void run() {
	    long[] fact = new long[21];
	    findFact(fact, 21);
	    
        int T = nextInt();
		while (T-- > 0) {
		    String[] line = nextLine().split(" ");
		    String S = line[0];
			long N = Long.parseLong(line[1]);
			
            String finalResult = "";
            int wordLength = S.length();
            
            int[] freq = new int[26];
            for (int i = 0; i < S.length(); i++) {
                freq[S.charAt(i) - 'a']++;
            }
/*            
// NOT WORKING
            long rankTillNow = 0;
            for (int len = 0; len < wordLength; len++) {
                for (int i = 0; i < 26; i++) {
                    if (freq[i] > 0) {
                        freq[i]--;
                        String result = finalResult + (char) (i + 'a');
                        long rankWillBecome = rankTillNow + fact[wordLength - len - 1];
                        if (rankWillBecome == N) {
                            for (int j = 26 - 1; j >= 0; j--) {
                                while (freq[j] > 0) {
                                    finalResult += (char) (j + 'a');
                                    freq[j]--;
                                }
                            }
                            break;
                        }
                        if (rankWillBecome < N) {
                            rankTillNow = rankWillBecome;
                            freq[i]++;
                            continue;
                        }
                        finalResult += (char) (i + 'a');
                        i = 0;
                        System.out.println(result);
                    }
                }
            }
            System.out.println(finalResult);
*/

/**
 * At the end of the second for loop 'j' contains the number of iterations
 * possible after fixing the value of 'len' in the first for loop. 
 * When this value is greater than 'N', then the required string is
 * lexicographically greater than all the strings with that 'len' value fixed.
 * In that case, we skip over those strings as done in line 96.
 * If however, j < N, then the string would have the character at
 * len_th position fixed and we look to fix the remaining characters.
*/
            for (int len = 0; len < wordLength; len++) {
                for (int i = 0; i < 26; i++) {
                    long rankTillNow = fact[wordLength - len - 1];
                    if (freq[i] > 0) {
                        for (int j = 0; j < 26; j++) {
                            if (j == i && freq[j] > 0) {
                                rankTillNow /= fact[freq[j] - 1];
                            }
                            else {
                                rankTillNow /= fact[freq[j]];
                            }
                        }
                        
                        if (N > rankTillNow){
                            N -= rankTillNow;
                        }
                        else {
                            finalResult += (char) (i + 'a');
                            freq[i]--;
                            break;
                        }
                    }
                }
            }
            println(finalResult);
		}
		close();
	}
	
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
    
	static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
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