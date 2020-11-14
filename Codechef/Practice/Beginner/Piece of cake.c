/*
 * https://www.codechef.com/problems/LCH15JAB
 * Author: Hmanshu Shekhar
 */

#include <stdio.h>

int main()
{
	int t;
	scanf("%d", &t);
	while (t--)
	{
		char s[50];
		scanf("%s", s);

		int hash[26];
		for (int i = 0; i < 26; i++)
			hash[i] = 0;

		float len = 0l;
		for (int i = 0; s[i] != '\0'; i++)
		{
			hash[s[i] - 'a']++;
			len++;
		}

		int flag = 1;
		for (int i = 0; i < 26; i++)
		{
			if (hash[i]*1.0 == len/2)
			{
				printf("YES\n");
				flag = 0;
				break;
			}
		}
		if (flag)
		{
			printf("NO\n");
		}
	}
	return 0;
}
