import java.io.*;
import java.util.*;

public class Solution {
	static int mod = (int) 1e9 + 7;
	static int[] fact = new int[(int) 1e6];
	
	public static void main(String[] args) throws IOException {
	    factorial(fact, (int) 1e5 + 5);
	    
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		String[] S = in.readLine().trim().split(" ");
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
		    s[i] = Integer.parseInt(S[i]);
		}
		
		String ans = "";
		if (n == 0 || n == 1) {
		    System.out.format("%.6f", (float) n);
		}
		
		double den = 1, num = 0;
		for (int i = 1; i <= n; i++) {
		    den = den * i;
		    for (int j = 1, d = 1; j <= i; d *= ++j) {
		        num = num + (den / d);
		    }
		}
		
		if ((n & 1) == 0) {
		    num = num - 1;
		}
		
		num = num - n;
		System.out.format("%.6f", (float) num / den);
	}
	
	static void factorial(int[] fact, int n) {
	    fact[0] = 1;
	    for (int i = 1; i < n; i++) {
	        fact[i] = (n * fact[n - 1]) % mod;
	    }
	}
}