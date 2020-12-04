import java.io.*;
import java.util.*;
import java.lang.*;

                            ///////////////////////
                            /// TO BE COMPLETED ///
                            ///////////////////////

/**
 * Numbers from 1 to 7, their Fibonacci number system representations are: 1, 10, 100, 101, 1000, 1001, 1010 respectively. eg :- 7 = 5 + 2 = fib(2) + fib(4) = 1010 and 12 = 8 + 3 + 1 = fib(5) + fib(3) + fib(1) = 10101
 * So the beginning of the string looks as follows: 110100101100010011010....
 * Find a part of the string starting from L up to R.
 * https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/practice-problems/algorithm/fibonacci-substring/
 *
 * The trick is to make a pattern : 1, 10, 100, 101, 1000, 1001, 1010, 10000, 10001, 10010, 10100, 10101, 100000, 100001, 100010, 100100, 100101, 101000, 101001, 101010, 1000000, 1000001, 1000010, 1000100, 1000101, 1001000, 1001001, 1001010, 1010000, 1010001, 1010010, 1010100, 1010101, 10000000, 10000001, 10000010, 10000100, 10000101, 10001000, ...
 * As soon as alternate ones appears, place one 1 before it
 * and then after the 1 place that many zeroes.
 */

class FibonacciSubstring implements Runnable {
	public static void main(String[] args) {
		new Thread(null, new FibonacciSubstring(), "Check2", 1 << 28).start(); // to increase stack size in java
	}
	
	public void run() {
		
		
		
		
		
		
		
		
		
		
		print((totalPaths - sum + mod) % mod);
		close();
	}

/*~~~~~~~~~~~~~~~~~    FAST OUTPUT METHODS    ~~~~~~~~~~~~~~~~~*/
	private static final PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
			}
            writer.print(objects[i]);
        }
    }

    public static void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public static void close() {
        writer.close();
    }

    public static void flush() {
        writer.flush();
    }
}