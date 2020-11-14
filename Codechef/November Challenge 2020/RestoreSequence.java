/**
 * https://www.codechef.com/NOV20B/problems/RESTORE
 * Author : Himanshu Shekhar
 */

							///////////////////
							/// Not working ///
							///////////////////
import java.util.*;
import java.io.*;
import java.text.*;

public class RestoreSequence
{
	public static BufferedReader in;
	public static PrintWriter out;
	public static StringBuilder sol;

	public static void main(String[] args) throws IOException
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sol = new StringBuilder();

		int t = Integer.parseInt(in.readLine());
		while(t-- > 0)
		{
			int n = Integer.parseInt(in.readLine());
			String[] inp = in.readLine().trim().split(" ");
			ArrayList<Integer>[] b = new ArrayList[n+1];
			for (int i = 0; i <= n; i++)
				b[i] = new ArrayList<Integer>();
			
			for (int i = 0; i < n; i++)
			{
				b[i] = new ArrayList<Integer>();
				int val = Integer.parseInt(inp[i]);
				b[val].add(i+1);		// 1-indexing while hashing
			}
			
			int[] a = new int[n];
			int k = 4000000 - 1;
			for (int i = 1; i <= n; i++)
			{
				if (b[i].size() > 1)
				{
					for (int j : b[i])
					{
						a[j-1] = k;		// using zero-indexing while writing answer
					}
					k--;
				}
			}

			for (int i = 1; i <= n; i++)
			{
				if (b[i].size() == 1)
				{
					for (int j : b[i])
					{
						a[j-1] = k;
					}
					k--;
				}
			}
			
			for (int i : a)
				sol.append(i + " ");
			sol.append("\n");
		}
		out.println(sol);
		out.close();
	}

}