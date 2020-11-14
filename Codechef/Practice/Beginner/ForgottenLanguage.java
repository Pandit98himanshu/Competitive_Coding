/**
 * https://www.codechef.com/problems/FRGTNLNG
 * Author: Himanshu Shekhar
 */

import java.util.*;
import java.io.*;

class ForgottenLanguage
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0)
		{
			String[] nk = br.readLine().split(" ");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);

			String[] dict = br.readLine().split(" ");
			ArrayList<String> phrases = new ArrayList<>();

			for (int i = 0; i < k; i++)
			{
				String[] lPhrase = br.readLine().split(" ");
				
				int l = Integer.parseInt(lPhrase[0]);
				for (int j = 1; j <= l; j++)
					phrases.add(lPhrase[j]);
			}

			for (int i = 0; i < n; i++)
				if (phrases.contains(dict[i]))
					out.print("YES ");
				else
					out.print("NO ");
			
			out.println();
		}
		out.flush();
	}
}