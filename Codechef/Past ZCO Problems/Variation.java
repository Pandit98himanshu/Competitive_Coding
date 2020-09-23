/**
 * https://www.codechef.com/ZCOPRAC/problems/ZCO15002
 */

import java.util.*;
import java.io.*;

class Variation {
	public static BufferedReader in;
	public static PrintWriter out;
	public static StringBuilder sol;
	public static Utilities util;

	public static void main(String[] args) throws IOException {	
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sol = new StringBuilder();
		util = new Utilities();

		String[] nk = in.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		String[] A = in.readLine().trim().split(" ");
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = Long.parseLong(A[i]);
		
		Arrays.sort(a);

		long var_count = 0;
		for (int i = 0; i < n; i++) {
			long curr = a[i] + k;
			int ind = util.upper_bound(a, curr);
			if (a[ind] >= curr)
				var_count += (n - ind);

			// debug
			//out.println(a[i] + " : " + var_count);
		}
					
		out.println(var_count);
		out.close();
	}
}

class Utilities {
	public static boolean[] prime;
	public static long[] fact;
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	public static int power(int a, int b) {
		int res = 1;
		while (b > 0) {
			if (b % 2 == 1)
				res = res * a;
			a = a * a;
			b = b / 2;
		}
		return res;
	}
	public static long power(long a, long b, long mod) {
		long res = 1;
		a = a % mod;
		b = b % mod;
		while (b > 0) {
			if (b % 2 == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			b = b / 2;
		}
		return res;
	}
	public static long modInv(long a, long mod) {
		return power(a, mod - 2, mod);
	}
	public static int upper_bound(long[] a, long key) {
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high) {
			mid = low + (high - low)/2;
			if (a[mid] < key)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
	public static void sieve(int n) {
		prime = new boolean[n+1];
		Arrays.fill(prime, true);

		for (int i = 2; i*i <= n; i++)
			if (prime[i] == true)
				for (int j = i*i; j <= n; j += i)
					prime[j] = false;
	}
	public static boolean isPrime(int n) {
		return prime[n];
	}
}

