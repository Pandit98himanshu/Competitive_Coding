#include <stdio.h>
void scnaf_int(long *n){
    register long c = getchar_unlocked();
    *n = 0;
    for( ; (c<48 || c>57); c = getchar_unlocked() );
    for( ; (c>47 && c<58); c = getchar_unlocked() ){
        *n = (*n<<1) + (*n<<3) +c -48;
    }
}
	
void readPages(long n) {
    if (n == 1) 
    {
        printf("1\n1 1");
        return;
    } 
    else 
    {
        printf("%ld\n", n / 2);
    }
    long pages = 3;
    if (n < 3) 
    {
        pages = n;
    }
    printf("%ld 1 ", pages);
    for (long i = 2; i <= n; i++) 
    {
        if (i == n && n % 2 == 0) 
        {
            pages = 1;
        }
        else 
        {
            pages = 2;
        }
        if (i % 2 == 0 && i != 2) 
        {
            printf("\n%ld %ld ", pages, i);
        } 
        else 
        {
            printf("%ld ", i);
        }
    }
}
int main() {
    long t;
    //scnaf_int(&t);
    scanf("%ld", &t);
    while (t--) 
    {
        long n;
        //scnaf_int(&n);
        scanf("%ld", &n);
        readPages(n);
        printf("\n");
    }
    return 0;
}