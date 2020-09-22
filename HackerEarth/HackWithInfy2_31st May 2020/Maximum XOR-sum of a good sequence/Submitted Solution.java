import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[n];
         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }

         int out_ = maximum_xor_sum(arr, n);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int maximum_xor_sum(int[] arr, int n){
        // calculate xor of whole array
        int xorSum = arr[0];
        for(int i = 1; i < n; i++) {
            xorSum = xorSum ^ arr[i];
        }
        // remove 1 elements one–by-one and check
        // whether it results bigger xor sum
        for(int i = 0; i < n/2; i++) {
            xorSum = modifiedArr(arr, n, i, n - i - 1, xorSum);
        }
        return xorSum;
    }
    static int modifiedArr(int[] arr, int n, int a, int b, int xorSum) {
        // calculate xor without element at index a & b
        int newXorSum = arr[0];
        for(int i = 1; i < n; i++) {
            if(i != a && i != b) {
                newXorSum = newXorSum ^ arr[i];
            }
        }
        // if xor sum without element at a & b is greater than
        // previously calculated xor sum then remove those elements from array
        if(newXorSum > xorSum) {
            //System.out.print(arr[a] + ", " + arr[b] + " : ");
            //System.out.println(newXorSum + " | " + xorSum);
            arr[a] = 0;
            arr[b] = 0;
            xorSum = newXorSum;
        }
        return xorSum;
    }
}