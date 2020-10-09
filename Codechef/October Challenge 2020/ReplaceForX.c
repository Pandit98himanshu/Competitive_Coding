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
		R[j] = a[m + j + 1];

	ll i = 0, j = 0, k = l;
	while (i < n1 && j < n2)
		if (L[i] <= R[j])
			a[k++] = L[i++];
		else
			a[k++] = R[j++];
	while (i < n1)
		a[k++] = a[i++];
	while (j < n2)
		a[k++] = a[j++];
}
void mergeSort(ll a[], ll l, ll r)
{
	if (l < r)
	{
		ll m = l + (r - l)/2;
		mergeSort(a, l, m);
		mergeSort(a, m + 1, r);
		merge(a, l, m, r);
	}
}
ll upper_bound(ll a[], ll l, ll r, ll k)
{
	while (low < high)
	{
		ll m = l + (r - l)/2;
		if (a[m] < key)
			l = m + 1;
		else
			r = m;
	}
	return l;
}
int main(void)
{
	ll t = 0;
	scanf("%lld", &t);
	while (t--)
	{
		ll n, x, p, k;
		scanf("%lld %lld %lld %lld", &n, &x, &p, &k);
		ll a[n];
		for (ll i = 0; i < n; i++)
			scanf("%lld", &a[i]);

		mergeSort(a);
		
		ll ind = upper_bound(a, 0, n-1, k);

	}
	return 0;
}
