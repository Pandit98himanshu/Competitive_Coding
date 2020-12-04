/*
 * https://www.codechef.com/problems/MNMX
 * Author: Himanshu Shekhar
 */

						////////////////////
						/// WRONG ANSWER ///
						////////////////////

#include <stdio.h>
#define ll long long int

int main()
{
	ll t;
	scanf("%lld", &t);
	while (t--)
	{
		ll n;
		scanf("%lld", &n);
		ll a[n];
		for (ll i = 0; i < n; i++)
			scanf("%lld", &a[i]);

		ll i = 0, ans = 0;
		for (ll j = i+1; j < n; j++)
		{
			if (a[i] > a[j])
			{
				i = j;
			}
			ans += a[i];
		}
		printf("%lld\n", ans);
	}
	return 0;
}