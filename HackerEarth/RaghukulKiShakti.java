import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/decide-nahi-hai/?layout=old
 */
 
class RaghukulKiShakti {
    final static int N = (int) 1e6 + 1;
    
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] a = new int[n];
        int[] freq = new int[N];
        Arrays.fill(freq, 0);
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            freq[a[i]]++;
        }
        int[] power = new int[N];
        Arrays.fill(power, 0);
        for (int i = 1; i < N; i++) {
            int f = freq[i];
            int totalMultiples = 0;
            for (int j = i + i; j < N; j += i) {
                if (freq[j] > 0) {
                    power[j] -= f;
                    totalMultiples += freq[j];
                }
            }
            power[i] += totalMultiples;
        }
        
        for (int i = 0; i < n; i++) {
            out.print(power[a[i]] + " ");
        }
        
        out.close();
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