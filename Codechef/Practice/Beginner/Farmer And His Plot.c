/**
 * https://www.codechef.com/problems/RECTSQ
 * Author: Himanshu Shekhar
 */

#include <stdio.h>

int main()
{
	int t;
	scanf("%d", &t);
	while(t--)
	{
		int n, m;
		scanf("%d %d", &n, &m);

		int min, max;
		if (n < m)
		{
			min = n;
			max = m;
		}
		else
		{
			min = m;
			max = n;
		}

		int ans;
		for(int i = 1; i <= min; i++)
		{
			if (min%i == 0)
			{
				int a = min/i;
				if (max%a == 0)
				{
					ans = max/a * i;
					break;
				}
			}
		}
		printf("%d\n", ans);
	}
	return 0;
}