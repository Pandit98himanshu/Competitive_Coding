/**
 * https://www.codechef.com/ZCOPRAC/problems/ZCO13003
 */

import java.util.*;
import java.io.*;

class Chewing {
	public static BufferedReader in;
	public static PrintWriter out;
	public static StringBuilder sol;
	public static Utilities util;

	public static void main(String[] args) throws IOException {	
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sol = new StringBuilder();
		util = new Utilities();

		String[] nk = in.readLine().trim().split(" ");
		int n = Integer.parseInt(nk[0]);
		long k = Long.parseLong(nk[1]);
		String[] inp = in.readLine().trim().split(" ");
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = Long.parseLong(inp[i]);
		
		Arrays.sort(a);

		long num = 0;
		for (int i = 0; i < n-1; i++) {
			if (k-a[i] <= 0) {
				break;
			}
			int ind = util.upper_bound_equals(a, k-a[i]) - 1;
			if ((ind-i > 0) && (a[i]+a[ind] < k)) {
				num += ind - i;
			}
			//debug
			System.out.println(a[i] + " = " + a[ind]);
		}
		
		out.println(num);
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
	// finds index of >= key
	public static int upper_bound_equals(long[] a, long key) {
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
	// finds index of > key
	public static int upper_bound(long[] a, long key) {
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high) {
			mid = low + (high - low)/2;
			if (a[mid] <= key)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
	// finds index of <= key
	public static int lower_bound_equals(long[] a, long key) {
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high) {
			mid = low + (high - low)/2;
			if (a[mid] > key)
				high = mid;
			else
				low = mid - 1;
		}
		return low;
	}

	// finds index of < key
	public static int lower_bound(long[] a, long key) {
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high) {
			mid = low + (high - low)/2;
			if (a[mid] >= key)
				high = mid;
			else
				low = mid - 1;
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

