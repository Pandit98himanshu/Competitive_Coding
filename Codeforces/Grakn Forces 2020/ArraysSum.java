/**
 * https://codeforces.com/contest/1408/problem/B
 */

import java.util.*;
import java.io.*;

public class ArraysSum
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
			String[] nk = in.readLine().trim().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			String[] inp = in.readLine().trim().split(" ");
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(inp[i]);
			
			if (k == 1)
			{
				boolean flag = true;
				for (int i = 1; i < n; i++)
				{
					if (a[i] != a[i-1])
					{
						flag = false;
						break;
					}
				}
				if (flag)
					sol.append("1\n");
				else
					sol.append("-1\n");
				continue;
			}

			int[] diff = new int[n];
			int count = 1;
			diff[0] = a[0]-0;
			for (int i = 1; i < n; i++)
			{
				diff[i] = a[i] - a[i-1];
				if (diff[i] > 0)
					count++;
			}

			sol.append((int) Math.ceil(count/(k-1)) + "\n");			
		}
		out.println(sol);
		out.close();
	}
						//////////////////
						/// INCOMPLETE ///
						//////////////////
	
	// IF YOU'VE TO FIND ALL THE POSSIBLE ARRAYS "b"
	public static ArrayList<ArrayList<Integer>> findB(int[] a, int n, int k, int[] diff)
	{
		int[] sum = new int[n];
		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(a[0]);
		for (int i = 1; i < n; i++)
		{
			
		}

		return b;
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

