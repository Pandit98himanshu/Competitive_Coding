import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/the-chocolate-boy-738c799b/description/?layout=old
 */

class TheChocolateBoy {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = in.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		double[] sweet = new double[n + 1];
		int[] price = new int[n + 1];

		int ind = 1;
		for (int i = 1; i <= n; i++) {
			String[] inp = in.readLine().split(" ");
			char type = inp[1].charAt(0);
			if (type == 'S') {
				sweet[ind] = Double.parseDouble(inp[2]);
				price[ind] = Integer.parseInt(inp[3]);
				ind++;
			}
		}

		System.out.println(solve(ind, m, sweet, price));
	}

	public static int solve(int n, int m, double[] sweet, int[] price) {
	    int maxPrice = 0;
	    // applying special power(makes element half) on each chocolate of "sweet" 
	    // array and find for which chocolate Jenish have to pay maximum price
		for (int i = 0; i < n; i++) {
		    sweet[i] /= 2;
		    int temp = knapsack(n, m, sweet, price);
		    sweet[i] *= 2;
		    
		    maxPrice = Math.max(maxPrice, temp);
		}
		return maxPrice;
	}
	
	// here, value = price & weight = sweetness
	public static int knapsack(int n, int W, double[] weight, int[] val) {
	    int[][] ks = new int[n + 1][W + 1];
	    
	    for (int i = 0; i <= n; i++) {
	        for (int j = 0; j <= W; j++) {
	            if (i == 0 || j == 0) {
	                ks[i][j] = 0;
	            }
	            else if (weight[i] <= j) {
	                ks[i][j] = Math.max(ks[i - 1][j], 
								val[i] + ks[i - 1][(int) (j - weight[i])]);
	            }
	            else {
	                ks[i][j] = ks[i - 1][j];
	            }
	        }
	    }
	    return ks[n][W];
	}
}