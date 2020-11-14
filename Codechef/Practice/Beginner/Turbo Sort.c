/*
 * https://www.codechef.com/problems/TSORT
 * Author: Himanshu Shekhar
 */

#include <stdio.h>
#define ll long long int

void merge(ll a[], ll l, ll m, ll r)
{
	ll n1 = m - l + 1;
	ll n2 = r - m;

	ll L[n1], R[n2];
	for (ll i = 0; i < n1; i++)
		L[i] = a[l + i];
	for (ll j = 0; j < n2; j++)
		R[j] = a[m + 1 + j];

	ll i = 0, j = 0, k = l;
	while (i < n1 && j < n2)
		if (L[i] < R[j])
			a[k++] = L[i++];
		else
			a[k++] = R[j++];
	while (i < n1)
		a[k++] = L[i++];
	while (j < n2)
		a[k++] = R[j++];
}

void merge_sort(ll a[], ll l, ll r)
{
	if (l < r)
	{
		ll m = l + (r - l)/2;
		merge_sort(a, l, m);
		merge_sort(a, m+1, r);
		merge(a, l, m, r);
	}
}

int main()
{
	ll t;
	scanf("%lld", &t);
	ll a[t];
	for (int i = 0; i < t; i++)
		scanf("%lld", &a[i]);
	
	merge_sort(a, 0, t-1);

	for (ll i = 0; i < t; i++)
		printf("%lld\n", a[i]);

	return 0;
}