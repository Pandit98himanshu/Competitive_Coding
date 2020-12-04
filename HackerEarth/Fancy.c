#include <stdio.h>
#include <string.h>
#include <stdbool.h>
/*
All fancy quotes which contain the word "not" are Real Fancy, quotes that do not contain it are regularly fancy.
https://www.codechef.com/problems/FANCY
solution :- https://www.codechef.com/viewsolution/22433887
*/
int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        char s[105];
        scanf("%[^\n]", s);
        
        //printf("%s\n", s);
        bool flag = false, flagN = false, flagO = false, flagT = false;
        
        for (int i = 0; s[i] != '\0'; i++) {
/* 
            if (s[i] == 'n' && s[i + 1] == 'o' && s[i + 2] == 't' && (s[i - 1] == ' ' || i == 0) && (s[i + 3] == ' ' || s[i + 3] == '\0')) {
                printf("\nReal Fancy\n");
                flag = true;
                break;
            }
 */
            if (s[i] == 'n') {
                //flagN = true;
                i++;
                if (s[i] == 'o') {
                    //flagO = true;
                    i++;
                    if (s[i] == 't') {
                        //flagT = true;
                        i++;
                        if(s[i] == ' ' || s[i] == '\0') {
                            flag = true;
                            printf("\nReal Fancy\n");
                            break;
                        }
                    }
                }
            }
            i--;
        }
        if (flag == false) {
            printf("\nregularly fancy\n");
        }
    }
    return 0;
}