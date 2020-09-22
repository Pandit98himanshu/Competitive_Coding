/**
 * https://www.codechef.com/COOK121B/problems/CHEFNWRK
 */

#include <stdio.h>
#define ll long long int
int main(void) {
    ll t;
    scanf("%lld", &t);
    while (t--) {
        ll n, k;
        scanf("%lld %lld", &n, &k);
        ll w[n];
        for (int i = 0; i < n; i++) {
            scanf("%lld", &w[i]);
        }
        
        ll i = 0, trips = 0, sum = 0;
    	while (i < n) {
    		if (w[i] > k) {
    			trips = -1;
    			break;
    		}
    		ll j = i + 1;
    		sum += w[i];
    		while (j < n && sum < k) {
    			sum += w[j];
    			j++;
    		}
    		trips++;
    		if (sum > k) {
    			i = j - 1;
    		}
    		else {
    		    i = j;
    		}
    		sum = 0;
    	}
    	printf("%lld\n", trips);
    }
	return 0;
}

