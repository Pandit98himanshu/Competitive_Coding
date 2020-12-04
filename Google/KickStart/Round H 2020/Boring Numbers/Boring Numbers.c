/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043b0c6
 * Author: Himanshu Shekhar
 */

							//////////////////
							/// NOT SOLVED ///
							//////////////////

#include <stdio.h>

#define ll long long int

int main(int argc, char const *argv[])
{
	ll t;
	scanf("%lld", &t);
	for (ll tc = 1; tc <= t; ++tc)
	{
		ll L, R;
		scanf("%lld %lld", &L, &R);
		// store numbers in an array
		ll l[18] = {-1}, r[18] = {-1};
		for (ll i = 0; L-- > 0; i++)
		{
			l[i] = L%10;
			L /= 10;
		}
		for (ll i = 0; R-- > 0; i++)
		{
			r[i] = R%10;
			R /= 10;
		}

		ll ans = 0;
		for (ll i = 0; l[i] > 0; i++)
		{

		}
		printf("Case #%lld: %lld\n", tc, ans);
	}
	return 0;
}