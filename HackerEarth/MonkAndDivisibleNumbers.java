/**
 * Problem : https://www.hackerearth.com/challenges/competitive/codemonk-number-threory-part-1/algorithm/monk-and-divisible-numbers-2/
 * Solution : https://github.com/divyanshgaba/Competitive-Coding/blob/master/Monk%20and%20Divisible%20Numbers/main.cpp
 */

						

class MonkAndDivisibleNumbers {
    final static long mod = (long) 1e9 + 7;
    // calculates (x^y) % mod
    static long modExpo(long x, long y) {
        long result = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod;
            y = y >> 1;
        }
        return result;
    }
    static long ModMultInv(long x) {
        return modExpo(x, mod - 2);
    }

						////////////////////
						// WRONG SOLUTION //
						////////////////////
    public static void main(String[] args) throws java.lang.Exception {
        java.util.Scanner in = new java.util.Scanner(System.in);
        java.io.PrintWriter out = new java.io.PrintWriter(System.out);
        
        int t = in.nextInt();
        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            
            long bPowc = modExpo(b, c);
            out.println("a = " + a + " b = " + b + " c = " + c + " bPowc = " + bPowc);
            if (a % bPowc == 0) {
                out.println("1");
            }
            else if ((((bPowc * ModMultInv(a)) % mod) * a) % bPowc == 0) {
                out.println((bPowc * ModMultInv(a)) % mod);
            }
            else {
                out.println(bPowc);
            }
        }
        out.close();
    }
}
