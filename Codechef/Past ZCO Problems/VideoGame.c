/**
 * https://www.codechef.com/ZCOPRAC/problems/ZCO14001
 */

#include <stdio.h>
#include <stdbool.h>
#include <limits.h>
#define ll long long int

int main(void) {
    ll n, h;
    scanf("%lld %lld", &n, &h);
    ll stk[n];
    for (ll i = 0; i < n; i++)
        scanf("%lld", &stk[i]);

    
	// performing operations on the crane
	ll cranePos = 0;			// initially crane is at position 0
	bool haveBox = false;	// initially crane have no box
	ll cmd;
	do {
	    scanf("%lld", &cmd);
		switch (cmd) {
			case 0: break;
			case 1: if (cranePos > 0)
						cranePos--;
					break;
			case 2: if (cranePos < n-1)
						cranePos++;
					break;
			case 3: if (!haveBox && stk[cranePos] > 0) {
						stk[cranePos]--;
						haveBox = true;
					}
					break;
			case 4: if (haveBox && stk[cranePos] < h) {
						stk[cranePos]++;
						haveBox = false;
					}
					break;
		}
	} while (cmd != 0);
	
	for (ll i = 0; i < n; i++) {
	    printf("%lld ", stk[i]);
	}

	return 0;
}
