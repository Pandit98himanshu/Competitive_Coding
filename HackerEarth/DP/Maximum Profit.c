/**
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/maximum-sum-12/description/
 *
 * Same as https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/bike-trip/
 */


#include <stdio.h>
#define ll long long int
ll max(ll a, ll b) {
	return a < b ? b : a;
}
ll min(ll a, ll b) {
	return a < b ? a : b;
}
int main(void) {
    ll n, x;
    scanf("%lld %lld", &n, &x);
    ll a[n + 1], b[n + 1];
    for (int i = 1; i <= n; i++) {
        scanf("%lld", &a[i]);
    }
    for (int i = 1; i <= n; i++) {
        scanf("%lld", &b[i]);
    }
    
    ll dp1[n + 1], dp2[n + 1];
    dp1[0] = dp2[0] = 0;
    for (int i = 1; i <= n; i++) {
        dp1[i] = max(dp1[i - 1], dp2[i - 1] - x) + a[i];
        dp2[i] = max(dp2[i - 1], dp1[i - 1] - x) + b[i];
    }
    
    ll ans = max(dp1[n], dp2[n]);
    printf("%lld", ans);
    return 0;
}