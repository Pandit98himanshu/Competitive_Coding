#include<stdio.h>
#include<stdbool.h>
#define ll long long int
int main() {
    ll n;
    scanf("%lld", &n);
    char q[1000005];
    scanf("%s", q);
    
    ll i = 0, n_ = 0, nA = 0, nB = 0;
	while (i < n) 
	{
	    if (q[i] == 'A') 
	    {
	        nA++;
            nA += n_;
            n_ = 0;
	    }
	    else if (q[i] == 'B') 
	    {
	        nB++;
	        n_ = 0;
	        i++;
	        bool flag = false;
	        while ((i < n) && (q[i] != 'A'))
	        {
	            if (q[i] == 'B') 
	            {
	                nB = flag ? nB + 1 : nB;
	                nB += n_;
	                n_ = 0;
	                flag = false;
	            }
	            i++;
	            n_++;
	            flag = true;
	        }
	        if (i >= n) 
	        {
	            nB += n_;
	            break;
	        }
	        if (q[i] == 'A') 
	        {
	            nA++;
	            nB += n_/2;
	            nA += n_/2;
	            n_ = 0;
	        }
	    }
	    else if (q[i] == '-') 
	    {
	        n_++;
	    }
	    i++;
	}
		
	if (nA > nB) {
	    printf("A");
	}
    else if (nB > nA) {
        printf("B");
    }
    else {
        printf("Coalition government");
    }
    return 0;
}