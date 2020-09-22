/**
 * https://www.codechef.com/JUNE20B/problems/XYSTR
 */
 
#include <stdio.h>
#include <string.h>

int main(void) {
	int t;
	scanf("%d", &t);
	while (t--) {
	    char str[100005];
	    scanf("%s", str);
	    
	    // calculate maximum pairs from forward
	    int max_pair1 = 0, max_pair2 = 0;
	    for(int i = 0; str[i + 1] != '\0'; i++) {
	        if ((str[i] == 'x' && str[i + 1] == 'y') || (str[i] == 'y' && str[i + 1] == 'x')) {
	            max_pair1++;
	            i++;
	        }
	    }
	    
	    	// calculate maximum pairs from backward
	    for(int i = strlen(str); i > 0; i--) {
	        if ((str[i] == 'x' && str[i - 1] == 'y') || (str[i] == 'y' && str[i - 1] == 'x')) {
	            max_pair2++;
	            i--;
	        }
	    }
	    
	    // print max of both
	    if (max_pair1 > max_pair2) {
	        printf("%d\n", max_pair1);
	    }
	    else {
	        printf("%d\n", max_pair2);
	    }
	}
	return 0;
}