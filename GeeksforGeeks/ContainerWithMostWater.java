/**
 * https://practice.geeksforgeeks.org/problems/container-with-most-water/0/?category[]=Arrays&category[]=Mathematical&category[]=Strings&category[]=Hash&problemType=full&difficulty[]=1&page=1&query=category[]Arrayscategory[]Mathematicalcategory[]Stringscategory[]HashproblemTypefulldifficulty[]1page1
 * Author : Himanshu Shekhar
 */

import java.util.*;
import java.io.*;
import java.text.*;

public class ContainerWithMostWater
{
	public static BufferedReader in;
	public static PrintWriter out;
	public static StringBuilder sol;
	public static Utilities util;
	public static DecimalFormat formatter;
	public static String pattern = "0.0000";

	public static void main(String[] args) throws IOException
	{	
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sol = new StringBuilder();
		util = new Utilities();
		formatter = new DecimalFormat(pattern);

		int t = Integer.parseInt(in.readLine());
		while(t-- > 0)
		{
			int n = Integer.parseInt(in.readLine());
			String[] inp = in.readLine().trim().split(" ");
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = Long.parseLong(inp[i]);
						//////////////////////
						/// Naive Approach ///
						//////////////////////
			// search for all possible areas and find maximum
			long maxArea = 0;
			for (int i = 0; i < n-1; i++)
			{
				long l, b;
				for (int j = i + 1; j < n; j++)
				{
					l = Math.min(a[i], a[j]);
					b = j - i;
					maxArea = maxArea < (l * b) ? (l * b) : maxArea;
				}
			}
			
			sol.append(maxArea + "\n");
		}
		out.println(sol);
		out.close();
	}
}

class Utilities
{
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
	// Sort according to 1st column, if values of 1st column are equal then sort according to 2nd column
	static final Comparator<double[]> nx2ArrayComparator = new Comparator<double[]>()
	{
		@Override
		public int compare(double[] x, double[] y)
		{
			if (x[0] != y[0])
				if (x[0] > y[0])
					return 1;
				else
					return -1;
			else
				if (x[1] > y[1])
					return 1;
				else
					return -1;
		}
	};
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

