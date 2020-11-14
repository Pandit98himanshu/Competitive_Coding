/*
 * https://www.codechef.com/problems/PALIN
 * Author: Himanshu Shekhar
 */

#include <stdio.h>
#include <stdbool.h>
#define million (int)1e6

bool isPalindrome(int n)
{
	// determining digits of the number "n"
	int temp = n, size = 0;
	while (temp > 0)
	{
		temp /= 10;
		size++;
	}

	// storing "n" in an array "num"
	int num[size];
	temp = n;
	for (int i = size-1; i >= 0; i--)
	{
		num[i] = temp%10;
		temp /= 10;
	}

	// check whether "num" array is palindrome or not
	for (int i = 0; i <= size/2; i++)
	{
		if (num[i] != num[size-1-i])
		{
			return false;
		}
	}
	return true;
}

int main()
{
	int t;
	scanf("%d", &t);

	while (t--)
	{
		int k;
		scanf("%d", &k);

		for (int i = k+1; i <= million; i++)
		{
			if (isPalindrome(i))
			{
				printf("%d\n", i);
				break;
			}
		}
	}
	return 0;
}