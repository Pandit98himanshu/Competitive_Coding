#include <stdio.h>

void swap(char str[], int a, int b)
{
	int temp = str[a];
	str[a] = str[b];
	str[b] = temp;
}

void reverse(char str[], int n, int index)
{
	if (index >= n/2)
	{
		return;
	}
	swap(str, index, n-index-1);
	return reverse(str, n, index+1);
}

int main()
{
	int n;
	scanf("%d", &n);

	char str[n+1];
	scanf("%s", str);

	reverse(str, n, 0);
	printf("%s\n", str);
	return 0;
}