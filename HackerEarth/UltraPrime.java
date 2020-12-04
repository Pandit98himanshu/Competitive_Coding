import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/ultra-prime/
 */
 
class UltraPrime {
    final static int N = (int) 1e6 + 1;
    static boolean[] prime = new boolean[N];
    static int[] ultraPrime = new int[N];
    
    static int digitSum(int x) {
        int sum = 0;
        for (sum = 0; x > 0; sum += x % 10, x /= 10);
        return sum;
    }
    static void sieve(int n) {
        Arrays.fill(prime, true);
        
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                // mark all multiples of i as false
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    static void findUltraPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                int sum = digitSum(i);
                if (prime[sum]) {
                    count++;
                }
            }
            ultraPrime[i] = count;
        }
    }
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        sieve(N - 1);
        findUltraPrimes(N - 1);
        int t = in.nextInt();
        while (t-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            
            
            System.out.println(ultraPrime[r] - ultraPrime[l - 1]);
        }
//         out.close();
    }
    
    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try { stringTokenizer = new StringTokenizer(bufferedReader.readLine()); }
                catch (IOException e) { }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        Long nextLong() { return Long.parseLong(next()); }

        Double nextDouble() { return Double.parseDouble(next()); }

        String nextLine() {
            String str = "";
            try { str = bufferedReader.readLine(); }
            catch (IOException e) { }

            return str;
        }
    }
}