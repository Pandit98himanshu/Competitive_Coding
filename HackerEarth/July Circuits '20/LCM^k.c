/*
 * https://www.hackerearth.com/challenges/competitive/july-circuits-20/algorithm/lcmk-a8c3e378/
 */
//Thu 23 Jul 2020 17:45:29 IST

#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<string.h>

#define ll long long int

ll power(ll x, ll y, ll mod) {
	x %= mod;
	y %= mod;
	
	ll res = 1;
	while (y > 0) {
		if ((y & 1) == 1) {
			res = (res * x) % mod;
		}
		x = (x * x) % mod;
		y /= 2;
	}
	return res;
}

ll d, x, y;
// Extended Euclid Theorem
void _GCD(ll a, ll b) {
    if(b == 0) {
        x = 1;
        y = 0;
		d = a;
	}
    else {
        _GCD(b, a%b);
        ll temp = x;
        x = y;
        y = temp - (a/b)*y;
    }
}

ll modInverse(ll a, lL mod) {
    _GCD(a, mod);
    return (x%mod + mod) % mod;    //x may be negative
}
// Euclid Theorem
ll GCD(ll a, ll b) {
	return (b == 0) ? a : GCD(b, a%b);
}

ll LCM(ll a, ll b, ll mod) {
	return ((a * b) % mod * modInverse(GCD(a, b), mod)) % mod;
}

int main(void) {
	ll t;
	scanf("%lld", &t);
	while (t--) {
		ll n, m, k;
		scanf("%lld %lld %lld", &n, &m, &k);
		ll a[n];
		for (int i = 0; i < n; i++) {
			scanf("%lld", &a[i]);
		}
		
		for (int i = 0; i < n; i++) {
			a[i] = power(a[i], k, m);
		}
		
		ll lcm = 1;
		for (int i = 0; i < n; i++) {
			lcm = LCM(lcm, a[i], m);
		}
		
		printf("%lld\n", lcm);
	}
	return 0;
}

