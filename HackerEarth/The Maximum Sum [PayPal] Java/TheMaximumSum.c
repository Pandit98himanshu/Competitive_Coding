import java.util.*;
/*
Can pass only 50% of test cases other gives TLE, for optimisation, may use Binary indexed tree
*/

class TestClass {
    /*
    static void merge(int[] a, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = a[j + mid + 1];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(L[i] > R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }
        while(i < n1) {
            a[k++] = L[i++];
        }
        while(j < n2) {
            a[k++] = R[j++];
        }
    }
    static void msort(int[] a, int l, int r) {
        if(l < r) {
            int mid = l + (r - l)/2;
            msort(a, l, mid);
            msort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }
    */
    static long aliceAns(int[] a, int[][] subarr, int n, int k) {
        // solve queries
        long aliceSum = 0;
        // prefix sum array
        int[] sumA = new int[n + 1];
        sumA[0] = 0;
        for(int i = 1; i < n + 1; i++) {
            sumA[i] = sumA[i - 1] + a[i - 1];
        }
        
        for(int i = 0; i < k; i++) {
            aliceSum += sumA[subarr[i][1] + 1] - sumA[subarr[i][0]];
        }
        
        return aliceSum;
    }
    static long bobAns(int[] a, int[][] subarr, int n, int k) {
        // 1. store occurence of indexes in all queries of subarrays
        // 2. sort array "a"
        // 3. find max element position in "occurs" array
        // 4. put last element in "dupA" at position according to previous position
        // 5. make that position -1 in "occurs"
        // 6. iterate from 1. to 3. until we exhaust array "a"


        // 1. store occurrence of indexes accessed for subarray
        int[] occurs = new int[n];
        Arrays.fill(occurs, 0); // initialize occurrence array with 0
        for(int i = 0; i < k; i++) {
            for(int j = subarr[i][0]; j <= subarr[i][1]; j++) {
                occurs[j]++;
            }
        }
        // 2. sort array "a" in increasing order
        Arrays.sort(a);

        int[] dupA = new int[n];
        
        // 6. repeat 1. to 3. until we exhaust array "a"
        for(int i = n - 1; i >= 0; i--) {
            // 3. finding maximum element in array "occurs"
            int max = occurs[0];
            int maxpos = 0;
            for(int j = 0; j < n; j++) {
                if(max < occurs[j]) {
                    max = occurs[j];
                    maxpos = j;
                }
            }
            // 4. put 1st element from sorted "a" at index "maxpos" in "dupA"
            dupA[maxpos] = a[i];
            // 5. make maximum element position in "occurs" array as -1
            occurs[maxpos] = -1;
        }
        
        // prefix sum array
        long bobSum = 0;
        int[] sumA = new int[n + 1];
        sumA[0] = 0;
        for(int i = 1; i < n + 1; i++) {
            sumA[i] = sumA[i - 1] + dupA[i - 1];
        }
        // solve queries now
        for(int i = 0; i < k; i++) {
            bobSum += sumA[subarr[i][1] + 1] - sumA[subarr[i][0]];
        }
        return bobSum;
    }
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();                 // Reading input from STDIN
        while(t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            int[][] subarr = new int[k][2];
            for(int i = 0; i < k; i++) {
                subarr[i][0] = s.nextInt() - 1;     // make 0 indexing
                subarr[i][1] = s.nextInt() - 1;     // make 0 indexing
            }
            long alice = aliceAns(a, subarr, n, k);
            long bob = bobAns(a, subarr, n, k);
            System.out.println(bob - alice);

        }      

    }
}