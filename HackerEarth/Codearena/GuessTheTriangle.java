/**
 * https://www.hackerearth.com/problem/algorithm/guess-the-triangle/
 */

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class GuessTheTriangle
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

		String[] P = in.readLine().trim().split(" ");
		double px = Double.parseDouble(P[0]);
		double py = Double.parseDouble(P[1]);

		String[] Q = in.readLine().trim().split(" ");
		double qx = Double.parseDouble(Q[0]);
		double qy = Double.parseDouble(Q[1]);

		String[] R = in.readLine().trim().split(" ");
		double rx = Double.parseDouble(R[0]);
		double ry = Double.parseDouble(R[1]);
/*
		String x1 = formatter.format(px + qx - rx);
		String y1 = formatter.format(py + qy - ry);

		String x2 = formatter.format(qx + rx - px);
		String y2 = formatter.format(qy + ry - py);

		String x3 = formatter.format(rx + px - qx);
		String y3 = formatter.format(ry + py - qy);
*/
		double totalX = px + qx + rx;
		double totalY = py + qy + ry;

		double[][] C = new double[3][2];
		C[0][0] = totalX - 2*px;		C[0][1] = totalY - 2*py;
		C[1][0] = totalX - 2*qx;		C[1][1] = totalY - 2*qy;
		C[2][0] = totalX - 2*rx;		C[2][1] = totalY - 2*ry;
		Arrays.sort(C, util.nx2ArrayComparator);
		for (int i = 0; i < 3; i++)
			System.out.format("%.4f %.4f\n", C[i][0], C[i][1]);
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

