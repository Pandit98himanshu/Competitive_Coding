/**
 * https://www.codechef.com/problems/HS08TEST
 * Author : Himanshu Shekhar
 */

#include <stdio.h>

int main(void)
{
	int x;
	float y;
	scanf("%d %f", &x, &y);

	if (x <= y - 0.5 && x % 5 == 0)
	{
		printf("%.2f", y - x - 0.5);
	}
	else
	{
		printf("%.2f", y);
	}
	return 0;
}