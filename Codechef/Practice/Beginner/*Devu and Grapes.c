/*
 * https://www.codechef.com/problems/DEVUGRAP
 * Author: Himanshu Shekhar
 */

						////////////////////
						/// WRONG ANSWER ///
						////////////////////

#include <stdio.h>
#define ll long long int

ll min(ll a, ll b)
{
	return a < b ? a : b;
}
int main()
{
	ll t;
	scanf("%lld", &t);
	while (t--)
	{
		ll n, k;
		scanf("%lld %lld", &n, &k);

		ll a, ans = 0;
		for (ll i = 0; i < n; i++)
		{
			scanf("%lld", &a);
			ll rem = a%k;
			ans += min(k - rem, rem);
		}
		printf("%lld\n", ans);
	}
	return 0;
}