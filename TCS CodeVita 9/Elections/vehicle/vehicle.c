#include<stdio.h>
#define ll long long int
ll mod = 1000000007;
ll fact[1000005];

void factorial(ll n) {
    fact[0] = 1;
    for (ll i = 1; i < n; i++) {
        fact[i] = (n * fact[n - 1]) % mod;
    }
}
	
int main() {

    // factorial(100005);
    
    ll n;
    scanf("%lld", &n);
    ll s[1000005];
    for (int i = 0; i < n; i++)
    scanf("%lld", s[i]);
    
	if (n == 0 || n == 1) {
	    printf("%.6f", (float) n);
	}
	
	double den = 1, num = 0;
	for (ll u = 1; u <= n; u++) {
	    den = den * u;
	    for (ll l = 1, d = 1; l <= u; d *= ++l) {
	        num = num + (den / d);
	    }
	}
	
	if ((n & 1) == 0) {
	    num = num - 1;
	}
	
	num = num - n;
	printf("%.6f", (float) num / den);
	return 0;
}