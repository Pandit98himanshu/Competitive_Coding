/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/power-of-twos-1/description/
 */

import java.io.*;
import java.util.*;

class PowerOfTwos {
	static int MAX = (int) 1e6;
	static int[] divs = new int[MAX + 1];
	// calculates number of divisors
	static void findDivisors() {
		for (int i = 2; i <= MAX; i++) {
			for (int j = i + i; j <= MAX; j += i) {
				divs[j]++;
			}
		}
	}
	public static void main(String[] args) throws IOException {
	    Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		findDivisors();
		// debug
		for (int i = 0; i < 20; i++) {
		    out.print(divs[i] + " ");
		}
		
		// prefix-sum
		for (int i = 2; i <= MAX; i++) {
			divs[i] += divs[i - 1] + 1;
		}

		
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			out.println(divs[n]);
		}
		out.close();
	}
}
