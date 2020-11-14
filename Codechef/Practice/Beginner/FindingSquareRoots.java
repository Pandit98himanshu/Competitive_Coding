/**
 * https://www.codechef.com/problems/FSQRT
 * Author: Himanshu Shekhar
 */

import java.util.*;
import java.io.*;

class FindingSquareRoots
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0)
		{
			int n = Integer.parseInt(br.readLine().trim());
			out.println((int) Math.sqrt(n));
		}
		out.flush();
	}
}