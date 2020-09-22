/**
 * https://www.codechef.com/JUNE20B/problems/CHFICRM
 */
 
#include<stdio.h>
#include<stdbool.h>

void scanf_int(int *n){
    register int c = getchar_unlocked();
    *n = 0;
    for( ; (c<48 || c>57); c = getchar_unlocked() );
    for( ; (c>47 && c<58); c = getchar_unlocked() ){
        *n = (*n<<1) + (*n<<3) +c -48;
    }
}

int main(void) {
    int t;
    scanf_int(&t);
    while (t--) {
        int n;
        scanf_int(&n);
        int a[n];
        for(int i = 0; i < n; i++) {
            scanf_int(&a[i]);
        }
        
        bool flag = true;
        //int inhand = 0;
        int den5 = 0, den10 = 0, den15 = 0;
        for(int i = 0; i < n; i++) {
            if (a[i] > 5) {
                // put amount a[i] in correct denomination box
                // and return correct balance, if not !!! HARE KRISHNA !!!
                if (a[i] == 10) {
                    den10++;
                    if (den5 == 0) {        // if a person comes with Rs.10,
                        flag = false;       // he'll get Rs.5 in return
                        break;
                    }
                    // returning balance of Rs.5
                    den5--;
                }
                else if (a[i] == 15) {
                    den15++;
                    if (den5 < 2 && den10 == 0) {        // if a person comes with Rs.15,
                        flag = false;                    // he'll get either (Rs.5) x 2 or, (Rs.10) x 1 in return
                        break;
                    }
                    // returning balance
                    if (den10 == 0) {                   // try to give Rs.10 first
                        den5 -= 2;                      // if Rs.10 is not available then give 2 denominations of Rs.5
                    }
                    else {
                        den10--;
                    }
                }
                /*
                if(inhand < a[i] - 5) {
                    flag = false;
                    break;
                }
                
                inhand -= a[i] - 5;
                */
            }
            else if (a[i] == 5) {
                //inhand += 5;
                den5++;
            }
            /***** ALSO HANDLES THE CASE WHERE PERSON COMES WITH COIN VALUE OTHER THAN 5, 10, & 15 *****/
            else {
                flag = false;
                break;
            }
        }
        if(flag) {
            printf("YES\n");
        }
        else {
            printf("NO\n");
        }
    }
    return 0;
}