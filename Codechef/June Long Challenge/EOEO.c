/**
 * https://www.codechef.com/JUNE20B/problems/EOEO
 */
 
#include<stdio.h>
#include<stdbool.h>
#define ll long long int
int main(void) {
    ll t;
    scanf("%lld", &t);
    while (t--) {
        ll ts;
        scanf("%lld", &ts);
        
        ll njs = 0;
        if((ts & 1) == 1) {     // if ts is odd then js can be all even numbers from 2 to (ts - 1)
            njs = (ts - 1) >> 1;
        }
        else {
            ll n = 0, __ts = ts;
            while ((__ts & 1) == 0) {
                __ts = __ts >> 1;
                n++;            // count the number of steps needed to make tom strength odd
            }
            /*
            
            ///////////////////
            /// BRUTE FORCE ///
            ///////////////////
            
            // now starting from i = 2, check number of possible values of js
            // such that base value "i" is even, to make jerry winner
            ll i = 2;
            ll js = i << n;
            while (js <= ts) {
                njs++;
                i += 2;
                js = i << n;
            }
            
            */
           /*
            /////////////////////////
            /// Efficient methods ///
            /////////////////////////
            
            ll start = ts - (1 << n);           // start = ts - 2^n
            njs = start/(1 << (n + 1));         // njs = start / 2^(n + 1)
            */
            njs = (__ts - 1) / 2;               // number of even numbers between 2 to __ts(where ts becomes odd after dividing it by 2 continuously)
        }
        printf("%lld\n", njs);
    }
    return 0;
}