/**
 * https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/maximum-substring-9b97fc5f/
 */

									//////////////////
									/// INCOMPLETE ///
									//////////////////
import java.io.*;
import java.util.*;
import java.lang.*;

class TheMaximuSubstring {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		String s = in.next();
		int[] lps = findLPS(s);
		new Utilities().debug(lps);
		
		out.close();
	}
	static int[] findLPS(String s) {
		int[] lps = new int[s.length()];
		lps[0] = 0;
		int len = 0, i = 1;
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if (len != 0) {
					len = lps[len - 1];
				}
				else {
					lps[i] = len;
					i++;
				}
			}
		}
		return lps;
	}
}	

/*~~~~~~~~~~~~~~~~~    UTILITY METHODS    ~~~~~~~~~~~~~~~~~*/
class Utilities {
	static long mod = (long) (1e9 + 7);

    static void debug(Object...args) {
		System.out.println(Arrays.deepToString(args));
	}

	static class Pair {
        int x;
        int y;

        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = (result * PRIME) + this.x;
            result = (result * PRIME) + this.y;
            return result;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair= (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
		
	static int lower_bound(int[] a, int low, int high, int key) {
	    while (low < high) {
	        int mid = low + ((high - low) >> 1);
	        if (a[mid] >= key) {
	            high = mid;
	        }
	        else {
	            low = mid + 1;
	        }
	    }
	    return low;
	}

	static int upper_bound(int[] a, int low, int high, int key) {
	    while (low < high) {
	        int mid = low + ((high - low) >> 1);
	        if (a[mid] <= key) {
	            low = mid + 1;
	        }
	        else {
	            high = mid;
	        }
	    }
	    return low;
	}
}
