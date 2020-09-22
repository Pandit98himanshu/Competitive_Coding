#include <stdio.h>
/*
BASIC IDEA
----------
● All the numbers can be represented as the difference of two squares except the numbers which yield the remainder of 2 when divided by 4; @Link = www.geeksforgeeks.org/check-whether-a-number-can-be-represented-as-difference-of-two-squares/
● [x % (2^n) = x & ((2^n) - 1)]; @Link = stackoverflow.com/questions/11040646/faster-modulus-in-c-c
*/
int main () {
    int t, n;
    scanf("%d", &t);
    while (t--) {
        scanf("%d",&n);
        int i, a[n];
        for (i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }
        
        //////////////////////////////
        /// Time Complexity : O(n) ///
        //////////////////////////////
        
        for (i = 0; i < n; i++) {
            a[i] = a[i] & 3;
            printf("a[%d] = %d\n", i, a[i]);
        }
        
        int j = 0, last02 = 0, next02 = 0;
        long count = 0;
        for (i = 0; i < n; i++) {
            
            if (a[i] == 0) {
                last02 = i + 1;
            }
            if (a[i] == 2) {
                /* 
                j = i - 1;
                while (a[j] != 0 && a[j] != 2 && j < 0) {
                    j--;
                }
                last02 = j;
                */
                
                j = i + 1;
                while (a[j] != 0 && a[j] != 2 && j >= n) {
                    j++;
                    printf("i = %d, j = %d\n", i, j);
                }
                next02 = j;
                
                count += 1 + last02 + next02 + last02 * next02;
                
                last02 = i + 1;
                i = next02 + 1;
            }
        }

        count = (n * (n - 1) / 2) - count;
        printf("%ld\n", count);
        
        
/*      
        ////////////////////////////////
        /// Time Complexity : O(n^2) /// Giving Wrong Answer
        //////////////////////////////// 
        
        int count = 0, prev_mod = 1, curr_mod = 0;
        int j;
        for (i = 0; i < n; i++) {
            prev_mod = 1;
            for (j = i; j < n; j++) {
                curr_mod = a[j] & 3;
                prev_mod = (prev_mod * curr_mod) & 3;
                if (prev_mod != 2) {
                    count++;
                }
            }   
        }
        
        printf("%d\n", count);
*/ 
        
    }
    return 0;
}