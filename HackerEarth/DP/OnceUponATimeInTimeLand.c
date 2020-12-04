/*
 * Once upon a time in Time-Land
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/once-upon-a-time-in-time-land/
 */
#include <stdio.h>
#define ll long long int

ll maxSum = 0;
void solve(int a, int n, int k, int sum, int start) {
    if (maxSum < sum) {
        maxSum = sum;
    }
    for (int i = start; i < n; i++) {
        if (a[i] > 0) {
            sum += a[i];
            return solve(a, n, k, sum, i + k + 1);
        }
    }
    return 0;
}

int main(void) {
    ll t;
    scanf("%lld", &t);
    
    while (t--) {
        ll n, k;
        scanf("%lld %lld", &n, &k);
        ll a[n];
        for (int i = 0; i < n; i++) {
            scanf("%lld", &a[i]);
        }
        
        solve(a, n, k, 0, 0);
        printf("%lld\n", maxSum);
    }       
    return 0;
}