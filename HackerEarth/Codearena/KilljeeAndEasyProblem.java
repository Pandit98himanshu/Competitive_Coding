/**
 * https://www.hackerearth.com/problem/algorithm/killjee-and-easy-problem-ef205c19/description/
 */

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class KilljeeAndEasyProblem
{
	public static BufferedReader in;
	public static PrintWriter out;

	public static void main(String[] args) throws IOException
	{	
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine());
		String[] inp = in.readLine().trim().split(" ");
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = Long.parseLong(inp[i]);
		
		long mod = (long) 1e10 + 11;
		long magicNum = 0;
		for (int i = 0; i < n; i++)
		{
			int setBits = 0;
			while (a[i] > 0)
			{
				setBits += (a[i]&1);
				a[i] >>= 1;
			}
			magicNum = (magicNum + power(setBits, i+1, mod)) % mod;
		}
		
		out.println(magicNum);
		out.close();
	}
	public static long power(int a, int b, long mod)
	{
		/*
		long res = 1;
		a = a % mod;
		while (b > 0)
		{
			if (b % 2 == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			b = b / 2;
		}
		*/
		long res = new BigInteger(a+"").modPow(new BigInteger(b+""), new BigInteger("10000000011")).longValue();
		return res;
	}
}
