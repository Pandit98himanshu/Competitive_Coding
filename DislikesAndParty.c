/*
You have organized a party and invited other N-1 friends to the party. Therefore, there are total friends. Everyone must shake hands with every other person except the people he or she dislikes. There are only 10 people at the party who dislike the other 9 people. The remaining people like everyone who is present at the party. Each friend has its own unique identity number.

Two friends shake hands only if both like each other. In other words, if any of them dislike others, then they cannot shake hands. You must calculate the number of handshakes done at the party.

Input format:
The first line contains a single integer N (10 ≤ N ≤ 10^9 ).
The next 10 lines contain 10 integers each. The first integer in a line represents the unique identity of a friend and the other 9 integers represent the identity number of people it dislikes.

Output format:
Print a single integer denoting the total number of handshakes.
 */
#include <stdio.h>

long dislikes[10][10];
int dupHS = 0;  // count for duplicate handshakes in dislikes array

long nC2 (long n) {
    return n*(n - 1)/2;
}

long dislikesAndParty(long dislikes[10][10], long n) {

    for(int i = 0; i < 10; i++) {
        for(int j = 1; j < 10; j++) {
            // Searching (i, j) in dislikes array
            for(int k = 0; k < 10; k++) {
                if(dislikes[k][0] == dislikes[i][j]) {
                    for(int l = 1; l < 10; l++) {
                        if(dislikes[i][0] == dislikes[k][l]) {
                            dupHS++;
                            dislikes[k][l] = 0;
                        }
                    }
                }
            }
        }
    }
/* 
    // For debugging
    printf("\n\n");
    for(int i = 0; i < 10; i++) {
        for(int j = 0; j < 10; j++) {
            printf("%ld ", dislikes[i][j]);
        }
        printf("\n");
    }
 */
    return (nC2(n) - (90 - dupHS));
}

int main () {
    long n;
    scanf("%ld", &n);
    
    for(int i = 0; i < 10; i++) {
        for(int j = 0; j < 10; j++) {
            scanf("%ld", &dislikes[i][j]);
        }
    }
    long handshakes = dislikesAndParty(dislikes, n);
    printf("%ld\n", handshakes);
    return 0;
}