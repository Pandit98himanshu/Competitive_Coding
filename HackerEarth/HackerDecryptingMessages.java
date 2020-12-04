import java.io.*;
import java.util.*;
/**
 * If X can be converted into product of two different or same prime numbers, then the print "YES", otherwise print "NO".
 * To convert X, you can choose one element from array say Y (X should be divisible Y), and can divide X by Y any number of times (till X is divisible by Y).
 * https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/hacker-with-prime-bebe28ac/description/?layout=old
 */
public class HackerDecryptingMessages {
    static final int N = (int) 1e6 + 1;
    static long[] gpf = new long[N];
    static boolean[] isAvailable = new boolean[N];
    
    static void greatestPrimeFactor() {
        Arrays.fill(gpf, -1);
        
        for (int i = 2; i < N; i++) {
            if (gpf[i] == -1) {
                for (int j = i; j < N; j += i) {
                    gpf[j] = i;
                }
            }
        }
    }
    static Vector<Long> uniquePrimeDivisors(long x) {
        Vector<Long> divisors = new Vector<Long>();
        while (x > 1) {
            long y = gpf[(int) x];
            divisors.add(y);
            while (x % y == 0) {
                x /= y;
            }
        }
        return divisors;
    }
    // for dividing with available numbers we’ve in array, helps in converting “x”
    static void findAvailableNumbers(long[] a, int n) {
        for (int i = 0; i < n; i++) {
            int j = (int) a[i];
            for (int k = j; k < N; k *= j) {
                isAvailable[k] = true;
            }
        }
    }
    static boolean isPossible(long x) {
        Vector<Long> divisor = uniquePrimeDivisors(x);
        for (int i = 0; i < divisor.size(); i++) {
            for (int j = 0; j < divisor.size(); j++) {
                //  if “x” can be converted into product of two different or same prime numbers, even after by converting “x”, return true
                if (x % (divisor.get(i) * divisor.get(j)) == 0) {
                    long temp = x / (divisor.get(i) * divisor.get(j));
                    if (temp == 1 || isAvailable[(int) temp]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();       // size of array
        int q = in.nextInt();       // number of queries
        long[] a = new long[n];     // array elements
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        // pre-calculation
        greatestPrimeFactor();      // generating greatest prime factor for all numbers
        findAvailableNumbers(a, n); // marking all numbers we’ve in array and their powers
        
        while (q-- > 0) {
            int x = in.nextInt();
            if (isPossible(x)) {
                out.println("YES");
            }
            else {
                out.println("NO");
            }
        }
        out.close();
    }
}