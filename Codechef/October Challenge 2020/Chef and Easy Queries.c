#include <stdio.h>
#include <stdbool.h>
#define ll long long int

int main(void)
{
    ll t;
    scanf("%lld", &t);
    while (t--)
    {
	ll n, k;
	scanf("%lld %lld", &n, &k);
	ll q[n];
	for (ll i = 0; i < n; i++)
	    scanf("%lld", &q[i]);
	
	for (ll i = 1; i < n; i++)
	    q[i] += q[i-1];

	bool ok = false;
	ll day = 0;
	for (ll i = 0; i < n; i++)
	{
	    q[i] = q[i] - (i+1) * k;
	    if (q[i] < 0)
	    {
		ok = true;
		day = i+1;
		break;
	    }
	}

	if (!ok)
	{
	    day = q[n-1]/k + 1 + n;
	}
	printf("%lld\n", day);
    }
    return 0;
}
