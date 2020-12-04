#include <stdbool.h>
#include <stdio.h>
/*
A plane journey
A flight company has to schedule a journey of 𝑁 groups of people from the same source to the same destination. Here, 𝐴1, 𝐴2, ..., 𝐴𝑁 represents the number of people in each group. All groups are present at the source. The flight company has 𝑀 planes where 𝐵1, 𝐵2, ..., 𝐵𝑚 represents the capacity of each plane.

You are required to send all groups to destination with the following conditions:

1. Each plane can travel from the Source to Destination with only one group at a time such that capacity of a plane is enough to accommodate all people in that group.
2. All people belonging to the same group travel together.
3. Every plane can make multiple journeys between source and destination.
4. It costs 1 unit of time to travel between source to destination and vice versa.

Note: Multiple planes can fly together and also it is not necessary for planes to end their journey at the source.

Determine the minimum time required to send all groups from the source to the destination. If it is not possible to perform this operation, then print -1.

Constraints
1 ≤ 𝑁,𝑀 ≤ 1𝑒5
1 ≤ 𝐴𝑖,𝐵𝑖 ≤ 1𝑒9

Time Limit: 1.0 sec
*/
// merge sort
void merge(long long int a[], int l, int m, int r)
{
	int n1 = m - l + 1;
	int n2 = r - m;
	long long int L[n1], R[n2];
	for(int i = 0; i < n1; i++)
	{
		L[i] = a[l + i];
	}
	for(int j = 0; j < n2; j++)
	{
		R[j] = a[m + j + 1];
	}

	int i = 0, j = 0, k = l;
	while(i < n1 && j < n2)
	{
		if(L[i] < R[j])
		{
			a[k++] = L[i++];
		}
		else
		{
			a[k++] = R[j++];
		}
	}
	while(i < n1)
	{
		a[k++] = L[i++];
	}
	while(j < n2)
	{
		a[k++] = R[j++];
	}
}
void m_sort(long long int a[], int l, int r)
{
	if(l < r) {
		int mid = l + (r - l) / 2;
		m_sort(a, l, mid);
		m_sort(a, mid + 1, r);
		merge(a, l, mid, r);
	}
}
int main(){
	long long int n, m;
	scanf("%lld %lld", &n, &m);
	long long int a[n], b[m];
	for(int i = 0; i < n; i++)
	{
		scanf("%lld", &a[i]);
	}
	for(int j = 0; j < m; j++)
	{
		scanf("%lld", &b[j]);
	}

	m_sort(a, 0, n - 1);
	m_sort(b, 0, m - 1);

	if(a[n - 1] > b[m - 1])
	{
		printf("-1\n");
		return 0;
	}
	int i = 0, j = 0;
	long long int time = 0, check = 0;
	bool flag = false;
	while(i < n)
	{
		while ((i < n) && (j < m))
		{
			if(a[i] <= b[j]) 
			{

				flag = true;
				i++;
				j++;
			}
			else    // (a[i] > b[j]) 
			{
				j++;
				check = j;
			}
		}
		if(flag) 
		{
			time++;
			flag = false;
		}
		// if all planes flew with m groups, then
		// wait till all m planes again come back
		if(j == m && i < n)
		{
			time++;	// all m flights again return from destination
			j = check;	// again carrying groups, (searching from checkpoint)
		}
		/*
		// if jth plane capacity is less than ith group
		// iterate till that plane which can sustain ith group
		while (a[i] > b[j] && ((i < n) && (j < m))) 
		{
			j++;
		}
		*/
	}
	printf("%lld\n", time);

	return 0;
}