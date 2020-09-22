/**
 * https://www.codechef.com/COOK121B/problems/KFOLD
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

int main(void) {
	ll t;
	scanf("%lld", &t);
	while (t--) {
		ll n, k;
		scanf("%lld %lld", &n, &k);
		ll a[1005], freq[2];
		freq[0] = freq[1] = 0;
		for (ll i = 0; i < n; i++) {
			scanf("%lld", &a[i]);
			freq[a[i]]++;
		}

		////	 K-foldable condition	////
		//	  i = 0
		//	  while (i + k < n)
		//		j = i + 2 * k - 1
		//		while (i < j)
		//			a[i++] == a[j--]

		
		printf("%lld\n", ans);
	}
	return 0;
}

