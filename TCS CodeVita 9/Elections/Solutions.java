import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		long n = Long.parseLong(in.readLine());
		char[] q = in.readLine().trim().toCharArray();
		
		long i = 0, n_ = 0, nA = 0, nB = 0;
		while (i < n) 
		{
		    if (q[(int) i] == 'A') 
		    {
		        nA++;
                nA += n_;
                n_ = 0;
		    }
		    else if (q[(int) i] == 'B') 
		    {
		        nB++;
		        n_ = 0;
		        i++;
		        while ((i < n) && (q[(int) i] != 'A')) 
		        {
		            if (q[(int) i] == 'B') 
		            {
		                nB++;
		                nB += n_;
		                n_ = 0;
		            }
		            i++;
		            n_++;
		        }
		        if (i >= n) 
		        {
		            nB += n_;
		            break;
		        }
		        if ((i < n) && (q[(int) i] == 'A')) 
		        {
		            nA++;
		            nB += n_/2;
		            nA += n_/2;
		            n_ = 0;
		        }
		    }
		    else if ((i < n) && (q[(int) i] == '-')) 
		    {
		        n_++;
		    }
		    i++;
		}
			
		if (nA > nB) {
		    System.out.println("A");
		}
        else if (nB > nA) {
            System.out.println("B");
        }
        else {
            System.out.println("Coalition government");
        }
	}
}