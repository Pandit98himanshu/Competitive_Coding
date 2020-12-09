#include <stdio.h>
#include <stdbool.h>

bool isPalindrome(char str[], int n, int i)
{
	if (i >= n/2)
		return true;

	if (str[i] != str[n-1-i])
		return false;
	return isPalindrome(str, n, i+1);
}

int main()
{
	int n;
	scanf("%d", &n);

	char str[n+1];
	scanf("%s", str);

	if(isPalindrome(str, n, 0))
		printf("YES\n");
	else
		printf("NO\n");
	return 0;
}