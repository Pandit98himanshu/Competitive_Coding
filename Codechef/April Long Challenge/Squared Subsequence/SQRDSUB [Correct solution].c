#include <stdio.h>
/*
A sequence S[1],S[2],…,S[K] is good if it is possible to find two integers p and q such that S[1]*S[2]*…*S[K] = p^2 − q^2.
Chef has a sequence A[1],A[2],…,A[N]. He wants to find the number of contiguous subsequences of A which are good.
https://www.codechef.com/APRIL20B/problems/SQRDSUB/
*/

/*
BASIC IDEA
----------
● All the numbers can be represented as the difference of two squares except the numbers which yield the remainder of 2 when divided by 4; @Link = www.geeksforgeeks.org/check-whether-a-number-can-be-represented-as-difference-of-two-squares/
● [x % (2^n) = x & ((2^n) - 1)]; @Link = stackoverflow.com/questions/11040646/faster-modulus-in-c-c
*/

void solve()
{
    long long int n;
    scanf("%lld", &n);
    long long int a[1000001], a2[1000001][2];
    long long int len=0;
    len=1;
    a2[0][0]=0;
    a2[0][1]=-1;
    for(int i=0;i<n;i++)
    {
        scanf("%lld", &a[i]);
        // if a[i] is divisible by 2
        if(a[i]%2==0)
        {
            // and, is divisible by 4 too
            if(a[i]%4==0)
            {
                // then on including ith element
                // that subarray will still remain “good”
                a[i]=0;
                a2[len][0]=0;
                a2[len][1]=i;
                len++;
            }
            else
            {
                // otherwise, product of elements of subarrays
                // will give remainder 2 when dividing by 4,
                // i.e., subarray is not “good”
                a2[len][0]=2;
                a2[len][1]=i;
                len++;
                a[i]=2;
            }
        }
    }
    a2[len][0]=0;
    a2[len][1]=n;
    len++;
    long long int cnt=0;
    for(int i=0;i<len;i++)
    {
        // count of subarrays which are not “good”
        if(a2[i][0]==2)
        {
            cnt+=(a2[i][1]-a2[i-1][1])*(a2[i+1][1]-a2[i][1]);
        }
    }
    // total number of subarrays
    long long int ans=(n*(n+1))/2;
    // number of “good” subarrays = total subarrays - bad subarrays
    printf("%lld\n", ans-cnt);
}

int main(void) {
	int t;
	scanf("%d",&t);
	while(t--)
	{
	    solve();
	}
	return 0;
}