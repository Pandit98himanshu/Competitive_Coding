import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/bob-and-the-clever-scoop/
 */
public class OneDividesTheOther {
    static final int N = (int) 1e6 + 1;
    static boolean[] prime = new boolean[N];
    
    public static void sieve() {
        // consider all numbers as prime initially
        java.util.Arrays.fill(prime, true);
        
        for(int i = 2; i * i < N; i++) {
            // remove all multiples of i
            if (prime[i]) {
                for (int j = i * i; j < N; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder ans = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int[] a = new int[n];
            String[] A = in.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(A[i]);
            }
            
            int[] freq = new int[100005];
            Arrays.fill(freq, 0);
            
            // store frequency of elements of array “a”
            for (int i : a) {
                freq[i]++;
            }
/*
            // find all factors of elements of array “a”
            int count = 0;
            for (int j = 0; j < n; j++) {
//                 System.out.print("\nj = " + a[j] + " ");
                for (int i = 1; i * i <= a[j]; i++) {
                    if (a[j] % i == 0) {
//                         System.out.print("freq[i] = " + freq[i] + " freq[n/i] = " + freq[n/i] + " ");
                        count += freq[i];
                        if (i != a[j] / i) {
                            count += freq[a[j] / i];
                        }
                        if (i == a[j] || a[j] / i == a[j]) {
                            count--;
                        }
//                         System.out.print("\ncount = " + count + " ");
                    }
                }
            }
*/            
            
            int count = 0;
            for (int j = 0; j < freq.length; j++) {
                if (freq[j] != 0) {
                    int innerCount = 0;
                    for (int i = 1; i * i <= j; i++) {
                        if (j % i == 0) {
                            innerCount += freq[i];
                            if (i != j / i) {
                                innerCount += freq[j / i];
                            }
                            if (i == j || j / i == j) {
                                innerCount--;
                            }
                        }
                    }
                    if (freq[j] > 1) {
                        count += innerCount * (freq[j] - 1);
                    }
                    else {
                        count += innerCount;
                    }
                }
            }
            
            System.out.println(count);
            //ans.append(count).append('\n');
        }
    }
}
