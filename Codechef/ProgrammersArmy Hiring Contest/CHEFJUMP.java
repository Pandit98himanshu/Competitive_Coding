/**
 * https://www.codechef.com/PAHC2020/problems/CHEFJUMP
 */

import java.io.*;
import java.util.*;
import java.lang.*;

class CHEFJUMP {
	public static String format(float x)
	{
		if (x == (long) x)
			return String.format("%x", (long) x);
		else
			return String.format("%s", x);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int t = Integer.parseInt(in.readLine());
		while (t-- > 0)
		{
			String[] hhmm = in.readLine().trim().split(":");
			int h = Integer.parseInt(hhmm[0]) % 12;
			int m = Integer.parseInt(hhmm[1]);

			// degree min-hand moved from 0
			float mDegree = 6 * m;
			// degree hour-hand moved from 0
			float hDegree = 30 * h;
			// extra degree hour-hand moves due to min-hand
			hDegree += mDegree / 12;
			// angle between min-hand and hour-hand
			float angleDiff = Math.abs(mDegree - hDegree);
			if (angleDiff > 180)
			{
				angleDiff -= 180;
			}

			out.println(format(angleDiff) + " degree");
		}
        out.close();
	}
}
