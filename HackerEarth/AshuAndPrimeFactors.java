import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
/**
 * https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-2/practice-problems/algorithm/ashu-and-prime-factors-4/?layout=old
 */
public class AshuAndPrimeFactors {
    static final int n = (int) 1e6 + 1;
    static boolean[] prime = new boolean[n];
    static HashMap<Integer, Integer> map = new HashMap<>();
    
    public static void sieve() {
        // consider all numbers as prime initially
        java.util.Arrays.fill(prime, true);
        int count = 0;
        
        for(int i = 2; i * i < n; i++) {
            // remove all multiples of i
            if (prime[i]) {
                count = 0;
                for (int j = i * i; j < n; j += i) {
                    if (prime[j]) {
                        count++;
                    }
                    prime[j] = false;
                }
                map.put(i, count + 1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        sieve();
        
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            
            if (map.get(x) == null) {
                System.out.println(1);
            }
            else {
                System.out.println(map.get(x));
            }
        }
        /*
        map.forEach((key, value) -> System.out.println(key + "\t=\t" + value));
        System.err.println("\n\n" + map.size());
        */
    }
}
