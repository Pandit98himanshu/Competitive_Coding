#include <stdio.h>
/*
https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/thanos-and-the-infinity-stones/
*/
#define ll long long
#define fr(i, a, b) for(i = a; i <= b; i++)
#define sf(a) scanf("%lld", &a)
#define pf(a) printf("%lld\n", a)

int main() {
    ll n;
    sf(n);
    ll a[n+2], i, pos[n+2];
    fr(i, 1, n) {
        sf(a[i]);
        pos[a[i]] = i;
    }
    ll len = 1, curr_pos = pos[1], curr_len = 1;
    fr(i, 2, n) {
        if(pos[i] > curr_pos) {
            curr_len++;
            len = len > curr_len ? len : curr_len;
        } else {
            curr_len = 1;
        }   
        curr_pos = pos[i];
    }
    pf(n - len);
}