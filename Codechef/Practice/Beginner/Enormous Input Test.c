/**
 * https://www.codechef.com/problems/INTEST
 * Author : Himanshu Shekhar
 */

#include <stdio.h>

int main(void)
{
	int n, k, ti, count = 0;
	scanf("%d %d", &n, &k);

	while (n--)
	{
		scanf("%d", &ti);
		if (ti % k == 0)
			count++;
	}
	printf("%d", count);
	return 0
}