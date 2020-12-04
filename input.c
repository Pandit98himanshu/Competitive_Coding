#include <stdio.h>
#define ll long long
   
void scanf_leave_int(int *n)
{
    register int c = getchar_unlocked();
    for( ; (c<48 || c>57); c = getchar_unlocked() );
    for( ; (c>47 && c<58); c = getchar_unlocked() );
}
 
void scanf_int(int *n){
    register int c = getchar_unlocked();
    *n = 0;
    for( ; (c<48 || c>57); c = getchar_unlocked() );
    for( ; (c>47 && c<58); c = getchar_unlocked() ){
        *n = (*n<<1) + (*n<<3) +c -48;
    }
}

void scanf_long(ll &n) {
    bool neg = false;
    register ll c;
    n = 0;
    c = getchar();
    if (c == '-') {
        neg = true;
        c = getchar();
    }
    for (; (c > 47 && c < 58); c = getchar())
        n = n * 10 + c - 48;
    if (neg)
        n *= -1;
}

int main()
{
	int i,n,q,a;
	scanf_int(&n);
	scanf_int(&q);
    int arr[n+1];
    for(i=1; i<=n; i++)
    	scanf_int(&arr[i]);
	
	while(q--){
		scanf_int(&a);
		if(a==1){
			ll x;
			scanf_long(x);
				arr[x] = !arr[x]; 
		}
		else if(a==0){
			int l,r;
			scanf_leave_int(&l);
			scanf_int(&r);
			if(arr[r]==1)
				printf("ODD\n");
			else
				printf("EVEN\n");
		}
	}
    return 0;
}