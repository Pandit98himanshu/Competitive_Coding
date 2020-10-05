/**
 * https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/battle-of-words/
 */

import java.util.*;
import java.io.*;

public class BattleOfWords
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
			String a = in.readLine().trim();
			String b = in.readLine().trim();

			int[] hashA = new int[26];
			int[] hashB = new int[26];

			for (int i = 0; i < a.length(); i++)
				if (a.charAt(i) != ' ')
					hashA[a.charAt(i) - 'a']++;

			for (int i = 0; i < b.length(); i++)
				if (b.charAt(i) != ' ')
					hashB[b.charAt(i) - 'a']++;

			for (int i = 0; i < 26; i++)
			{
				int commonWords = Math.min(hashA[i], hashB[i]);
				hashA[i] -= commonWords;
				hashB[i] -= commonWords;
			}

			int lenA = 0;
			int lenB = 0;
			for (int i = 0; i < 26; i++)
			{
				lenA += hashA[i];
				lenB += hashB[i];
			}

			if (lenA == 0)
				sol.append("You lose some.\n");
			else if (lenB == 0)
				sol.append("You win some.\n");
			else
				sol.append("You draw some.\n");

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

