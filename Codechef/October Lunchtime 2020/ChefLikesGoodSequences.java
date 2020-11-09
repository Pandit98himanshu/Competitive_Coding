/**
 * https://www.codechef.com/LTIME89B/problems/GSUB
 * Author : Himanshu Shekhar
 */

							//////////////////////////
							/// GIVES WRONG ANSWER ///
							//////////////////////////
import java.util.*;
import java.io.*;
import java.text.*;

class ChefLikesGoodSequences
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
			String[] nq = in.readLine().split(" ");
			int n = Integer.parseInt(nq[0]);
			int q = Integer.parseInt(nq[1]);

			String[] A = in.readLine().split(" ");
			int[] a = new int[n+2];
			for(int i = 1; i <= n; i++)
				a[i] = Integer.parseInt(A[i-1]);

			// count the length of longest subsequence before accepting queries
			int count = 0;
			for (int i = 1; i <= n; i++)
			{
				if (a[i-1] != a[i])
					count++;
			}

			while (q-- > 0)
			{
				String[] xy = in.readLine().split(" ");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);

				if (a[x] != y)
				{
					// if both previous and next elements are equal to a[x]
					if (a[x] == a[x-1] && a[x] == a[x+1])
						count += 2;
					// if either previous or next element is equal to a[x]
					else if ((a[x] == a[x-1] && a[x] != a[x+1]) || (a[x] != a[x-1] && a[x] == a[x+1]))
						if (a[x-1] != y && a[x+1] != y)
							count++;
					// if both previous and next elements are not equal to a[x] 
					else if (a[x] != a[x-1] && a[x] != a[x+1])
						// if both previous and next elements are equal and they are equal to "y"
						if (a[x-1] == a[x+1] && a[x-1] == y)
							count -= 2;
						// or, both previous and next elements are not equal
						else if (a[x-1] != a[x+1])
							// and, either previous or next element is equal to "y"
							if (a[x-1] == y || a[x+1] == y)
								count--;
				}
				a[x] = y;
				sol.append(count + "\n");

			}
			
			
			
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

