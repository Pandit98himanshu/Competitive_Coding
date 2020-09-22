/*
The pages of the book are numbered 1 through N. Over a series of days, Chef wants to read each page. On each day, Chef can choose to read any set of pages such that there is no prime that divides the numbers of two or more of these pages, i.e. the numbers of pages he reads on the same day must be pairwise co-prime
https://www.codechef.com/APRIL20B/problems/UNITGCD/
*/
#include<stdio.h>
int main()
{
    int t, k;
    scanf("%d", &t);
    while (t--)
    {  
        int n, i;
        scanf("%d", &n);
        // If number of pages are 1, it takes 1 day to complete 1 page
        if (n == 1) 
        {
            printf("1\n1 1\n");
            continue;
        }
        // else it takes n/2 days to complete n pages, because evens are
        // not co-primes and even number occurs at a difference of 2.
        printf("%d\n", n/2);
        // If total number of pages are odd, then chef can read 3 pages
        // on 1st day, i.e., 1, 2 and last page because any odd number
        // is not co-prime with 1 & 2.
        if (n % 2 != 0)
        {
            printf("3 1 2 %d\n", n);
        }
        // else he can read only 2 pages, i.e., 1 & 2
        else 
        {
            printf("2 1 2\n");
        }
        // for rest of the pages
        for (i = 4; i <= n; i += 2)
        {
            printf("2 %d %d\n", i-1, i);
        }
    }
    return 0;
}