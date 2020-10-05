/**
 * https://codeforces.com/contest/1408/problem/A
 */

import java.util.*;
import java.io.*;

public class CircleColoring
{
	public static BufferedReader in;
	public static PrintWriter out;
	public static StringBuilder sol;
	public static Utilities util;

	public static void main(String[] args) throws IOException
	{	
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sol = new StringBuilder();
		util = new Utilities();

		int t = Integer.parseInt(in.readLine());
		while(t-- > 0)
		{
			// taking inputs
			int n = Integer.parseInt(in.readLine());
			String[] inp = in.readLine().trim().split(" ");
			long[] a = new long[n], b = new long[n], c = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = Long.parseLong(inp[i]);
			inp = in.readLine().trim().split(" ");
			for (int i = 0; i < n; i++)
				b[i] = Long.parseLong(inp[i]);
			inp = in.readLine().trim().split(" ");
			for (int i = 0; i < n; i++)
				c[i] = Long.parseLong(inp[i]);


			int i = 0;
			long[] p = new long[n];
			p[0] = a[0];		// take 1st value from array "a"
			// since a[i] ≠ b[i] ≠ c[i], therefore, if a[i] equals previous value, we'll choose b[i]
			for (i = 1; i < n-1; i++)
			{
				if (a[i] == p[i-1])
					p[i] = b[i];
				else
					p[i] = a[i];
			}
			// we've to take different value for p[n-1] than p[0] and p[n-2]
			if (a[i] == p[i-1] || a[i] == p[0])
				if (b[i] == p[i-1] || b[i] == p[0])
					p[i] = c[i];
				else
					p[i] = b[i];
			else
				p[i] = a[i];

			for (long val : p)
				sol.append(val + " ");
			sol.append("\n");
		}
		out.println(sol);
		out.close();
	}

	/**
	 * IF a[i], b[i], & c[i] CAN BE SAME:
	 * we have to use backtracking
	 * p[i] ≠ p[i-1]	- solved
	 * p[0] ≠ p[n-1]	- not solved
	 * Not solved for test-cases like:
	 * 2 1 1
	 * 3 1 1
	 * 2 2 1
	 */
	public static long[] solve(long[] a, long[] b, long[] c, long[] p, int n, int i)
	{
		if (i == n)
			return p;
		else if (a[i] != p[i-1])
		{
			p[i] = a[i];
			return solve(a, b, c, p, n, i+1);
		}
		else if (b[i] != p[i-1])
		{
			p[i] = b[i];
			return solve(a, b, c, p, n, i+1);
		}
		else if (c[i] != p[i-1])
		{
			p[i] = c[i];
			return solve(a, b, c, p, n, i+1);
		}
		else
			return solve(a, b, c, p, n, i-1);
	}
}

class Utilities {
	public static boolean[] prime;
	public static long[] fact;

	public static int gcd(int a, int b)
	{
		return b == 0 ? a : gcd(b, a%b);
	}
	public static long gcd(long a, long b)
	{
		return b == 0 ? a : gcd(b, a%b);
	}
	public static int power(int a, int b)
	{
		int res = 1;
		while (b > 0)
		{
			if (b % 2 == 1)
				res = res * a;
			a = a * a;
			b = b / 2;
		}
		return res;
	}
	public static long power(long a, long b, long mod)
	{
		long res = 1;
		a = a % mod;
		b = b % mod;
		while (b > 0)
		{
			if (b % 2 == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			b = b / 2;
		}
		return res;
	}
	public static long modInv(long a, long mod)
	{
		return power(a, mod - 2, mod);
	}
	// finds index of >= key
	public static int upper_bound_equals(long[] a, long key)
	{
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high)
		{
			mid = low + (high - low)/2;
			if (a[mid] < key)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
	// finds index of > key
	public static int upper_bound(long[] a, long key) 
	{
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high)
		{
			mid = low + (high - low)/2;
			if (a[mid] <= key)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
	// finds index of <= key
	public static int lower_bound_equals(long[] a, long key)
	{
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high)
		{
			mid = low + (high - low)/2;
			if (a[mid] > key)
				high = mid;
			else
				low = mid - 1;
		}
		return low;
	}

	// finds index of < key
	public static int lower_bound(long[] a, long key)
	{
		int low = 0, high = a.length - 1;
		int mid;
		while (low < high)
		{
			mid = low + (high - low)/2;
			if (a[mid] >= key)
				high = mid;
			else
				low = mid - 1;
		}
		return low;
	}
	public static void sieve(int n)
	{
		prime = new boolean[n+1];
		Arrays.fill(prime, true);

		for (int i = 2; i*i <= n; i++)
			if (prime[i] == true)
				for (int j = i*i; j <= n; j += i)
					prime[j] = false;
	}
	public static boolean isPrime(int n)
	{
		return prime[n];
	}
}

