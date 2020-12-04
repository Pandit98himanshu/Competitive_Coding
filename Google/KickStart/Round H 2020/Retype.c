/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043adc7
 * Author: Himanshu Shekhar
 */


#include <stdio.h>

#define ll long long int

ll min(ll a, ll b)
{
	return a<b ? a : b;
}
int main(int argc, char const *argv[])
{
	ll t;
	scanf("%lld", &t);
	for (ll tc = 1; tc <= t; tc++)
	{
		ll n, k, s;
		scanf("%lld %lld %lld", &n, &k, &s);

		ll a = k + n;
		ll b = (k-1) + (k-s) + (n-s+1);
		ll ans = min(a, b);
		printf("Case #%lld: %lld\n", tc, ans);
	}
	return 0;
}