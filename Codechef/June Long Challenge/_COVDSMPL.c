#include <stdio.h>
#include <stdlib.h>

void scanf_int(int *n){
    register int c = getchar_unlocked();
    *n = 0;
    for( ; (c < 48 || c > 57); c = getchar_unlocked() );
    for( ; (c > 47 && c < 58); c = getchar_unlocked() ){
        *n = (*n << 1) + (*n << 3) + c - 48;
    }
}

int n;          // size of matrix
int m[61][61];

// asking queries using binary search
void ask_queries(int r1, int c1, int r2, int c2) {
    // asking queries
    printf("1 %d %d %d %d\n", r1, c1, r2, c2);
    // getting replies
    int x;
    scanf_int(&x);
    
    // either there is too many queries or invalid query has been asked
    if (x < 0 || (r1 < 1 || c1 < 1 || r2 < 1 || c2 < 1) || 
                 (r1 > n || c1 > n || r2 > n || c2 > n)) {
        return;
    }
    
    // base cases
    if (x == 0) {                                // if infected people in given range == 0,
        for (int c = c1; c <= c2; c++) {         // then don’t ask further queries for that range,
            m[r1][c] = 0;                        // simply put 0 in all cells of that range
        }

    }
    else if (x == (c2 - c1 + 1)) {               // if number of infected people equals
        for (int c = c1; c <= c2; c++) {         // number of cells in selected range,
            m[r1][c] = 1;                        // simply put 1 in all cells of that range
        }

    }
    else {
    
        // we’ve reached end of matrix
        if (c1 == c2 && r1 == n) {
            return;
        }
        // only 1 cell is selected
        else if (c1 == c2 && r1 < n) {
            // putting values in matrix
            m[r1][c1] = x;
            // move to next row and ask query for whole row
            ask_queries(r1 + 1, 1, r2 + 1, n);
        }
        else {
            int mid = (c2 - c1 + 1) / 2;
            ask_queries(r1, c1, r2, mid);
            ask_queries(r1, mid + 1, r2, c2);
        }
        
    }
    ask_queries(r1 + 1, 1, r2 + 1, n);
}

int main(void) {
    int t;
    scanf_int(&t);
    while (t--) {
        int p;
        scanf_int(&n);
        scanf_int(&p);
                            
        int x;
/*
                            ///////////////////
                            /// BRUTE FORCE ///
                            ///////////////////
                            
        // asking queries for every cell
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                // asking queries
                printf("1 %d %d %d %d\n", r, c, r, c);
                // getting replies
                scanf_int(&x);
                // either there is too many queries or invalid query has been asked
                if (x < 0) {
                    return 0;
                }
                // putting values in matrix
                m[r][c] = x;
            }
        }
*/
        // ask queries row-by-row and start from 1st row
        ask_queries(1, 1, 1, n);
        
        // printing generated matrix
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                printf("%d ", m[r][c]);    
            }
            printf("\n");
        }
        // checking whether outputted answer is correct or not
        int correct;
        scanf_int(&correct);
        if (!correct) {
            return 0;
        }
        
        fflush(stdout);
    }
    return 0;
}