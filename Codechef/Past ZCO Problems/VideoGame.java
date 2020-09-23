/**
 * https://www.codechef.com/ZCOPRAC/problems/ZCO14001
 */

import java.util.*;
import java.io.*;

class VideoGame {
	public static BufferedReader in;
	public static PrintWriter out;
	public static StringBuilder sol;


	public static void main(String[] args) throws IOException {	
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sol = new StringBuilder();

		// taking inputs
		String[] size = in.readLine().split(" ");
		int n = Integer.parseInt(size[0]);
		int h = Integer.parseInt(size[1]);

		String[] stack = in.readLine().trim().split(" ");
		long[] stk = new long[n];
		for (int i = 0; i < n; i++)
			stk[i] = Long.parseLong(stack[i]);

		String[] operation = in.readLine().trim().split(" ");
		int[] opr = new int[operation.length];
		for (int i = 0; i < opr.length; i++)
			opr[i] = Integer.parseInt(operation[i]);
		
		int cranePos = 0;			// initially crane is at position 0
		boolean haveBox = false;	// initially crane have no box
		
		// performing operations on the crane
		loop : for (int cmd : opr) {
			switch (cmd) {
				case 0: break loop;
				case 1: if (cranePos > 0)
							cranePos--;
						break;
				case 2: if (cranePos < n-1)
							cranePos++;
						break;
				case 3: if (!haveBox && stk[cranePos] > 0) {
							stk[cranePos]--;
							haveBox = true;
						}
						break;
				case 4: if (haveBox && stk[cranePos] < h) {
							stk[cranePos]++;
							haveBox = false;
						}
						break;
			}
		}

		for (long val : stk) {
			sol.append(val + " ");
		}
				
		out.println(sol);
		out.close();
	}
}

