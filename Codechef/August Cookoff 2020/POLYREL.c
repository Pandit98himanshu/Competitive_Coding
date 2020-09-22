/**
 * https://www.codechef.com/COOK121B/problems/POLYREL
 */

#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<string.h>

#define ll long long int

ll power(ll x, ll y, ll m) {
	x %= m;
	y %= m;

	ll res = 1;
	while (y > 0) {
		if ((y & 1) == 1) {
			res = (res * x) % m;
		}
		x = (x * x) % m;
		y /= 2;
	}
	return res;
}

ll GCD(ll a, ll b) {
	if (b == 0) return a;
	return GCD(b, a % b);
}

ll LCM(ll a, ll b, ll m) {
	ll num = (a * b) % m;
	ll den = GCD(a, b) % m;
	return (num / den) % m;
}

ll solve(ll n, ll sides) {
	if (n <= 5) {
		return sides;
	}
	return solve(n / 2, sides + n / 2);
}

int main(void) {
	ll t;
	scanf("%lld", &t);
	while (t--) {
		ll n;
		scanf("%lld", &n);
		ll a[n][2];
		for (ll i = 0; i < n; i++) {
			scanf("%lld %lld", &a[i][0], &a[i][1]);
		}

		ll sides = n;
		sides = solve(n, sides);
		
		printf("%lld\n", sides);
	}
	return 0;
}

