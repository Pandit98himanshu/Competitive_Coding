import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;

/**
 * https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/hardik-and-boxes-1/?layout=old
 */
 
class HardikAndBoxes implements Runnable {
	public static void main(String...args) {
		new Thread(null, new HardikAndBoxes(), "Check2", 1 << 28).start(); // to increase stack size in java
	}
    
	public void run() {
	// step 1 : remove all multiples from the array
	// step 2 : find all subsequences of remaining array
	// step 3 : if length of subsequence is equal to 1, then add number of multiples ranges from 1 to N
	// step 4 : else if length of subsequence is more than 1, find its LCM (say X) and subtract all the multiples of X ranges from 1 to N
	// step 5 : print the result
	    int n = nextInt();
	    int N = nextInt();
	    
	    Vector<Integer> w = new Vector<Integer>();
	    for (int i = 0; i < n; i++) {
	        w.add(nextInt());
	    }
	    
	    w = removeMultiples(w);
	    println(solve(w, w.size(), N)); 
		close();
	}
	
/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
	static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}
	
	static Vector<Integer> removeMultiples(Vector<Integer> v) {
	    Collections.sort(v);
	    
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                if (i != j && gcd(v.get(i), v.get(j)) > 1) {
                    Integer ele = v.get(j);
                    v.remove(ele);
                }
            }
        }
        return v;
    }
    
    static Vector<Integer> findSubsequencesUtil(Vector<Integer> v, int n, int counter) {
	    Vector<Integer> sub = new Vector<Integer>();
		for (int i = 0; i < n; i++) {
			if (BigInteger.valueOf(counter).testBit(i)) 
			    sub.add(v.get(i));
		}
		return sub;
	}
	
	static int solve(Vector<Integer> v, int n, int N) {
	    int result = 0;
	    
		/* Number of subsequences is (2^n -1)*/
		int opsize = (int)Math.pow(2, n); 
	    
		/* Run from counter 000..1 to 111..1*/
		for (int counter = 1; counter < opsize; counter++) { 
			Vector<Integer> x = findSubsequencesUtil(v, n, counter);
			if ((x.size() & 1) == 1) {
			    result += N/LCM(x);
			}
			else {
			    result -= N/LCM(x);
			}
			System.out.println(result);
		}
		return result;
	}
	
	static int LCM(Vector<Integer> v) {
	    int result = v.get(0);
	    for (int i = 1; i < v.size(); i++) {
	        result = lcm(result, v.get(i));
	    }
	    return result;
	}
	
	static int lcm(int x, int y) {
	    return (x * y) / gcd(x, y);
	}
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
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