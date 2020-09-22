// https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/unique-subsequence-264057c9/


#include <math.h>
#include <stdio.h>

void input(int *x){
    register int c = getchar_unlocked();
    *x = 0;
    for( ; (c<48 || c>57); c = getchar_unlocked());
    for( ; c>47 && c<58; c = getchar_unlocked()){
        *x = (*x<<1) + (*x<<3) + c - 48;
    }
}


int main(){
	int t;
	input(&t);
	while(t--){
	    int n;
	    input(&n);
	    
	    char s[n];
	    scanf("%s", s);

        int maxCount = 0, count = 0;
        char curr = s[0], prev = s[0];
        if(n > 1) {
            for(int i = 1; i < n; i++) {
                curr = s[i];
                
                count++;
                
                if(i == (n - 1) || prev == curr) {
                    if(maxCount < count) {
                        maxCount = count;
                    }
                    count = 0;
                }
                
                prev = curr;
            }
        }
        else {
            maxCount = 1;
        }
        printf("%d\n", maxCount);
	}
	return 0;
}