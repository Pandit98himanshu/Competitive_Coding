/*
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/special-shop-69904c91/
 */

#include<stdio.h>

int A, B, n1, n2, Price, oldPrice, newPrice;

int LeastPrice(a, b) {
	while(1) {
		oldPrice = A*a + B*b;
		if(a>=0 && b>=0) {
			a++;
			b--;
		}
		else
			return oldPrice;
		newPrice = A*a + B*b;
		if(newPrice < oldPrice)
			LeastPrice(a, b);
		else
			return oldprice;
	}
}

int main() {
	if((A<B && n1<n2) || (A>B && n1>n2)) {
		Price = A*(n2*n2) + B*(n1*n1);
		Price = LeastPrice(<#a#>, <#b#>);
	}
	else if((A<B && n1<n2) || (A>B && n1>n2)) {
		Price = A*(n1*n1) + B*(n2*n2);
		Price = LeastPrice(<#a#>, <#b#>);
	}
	printf("%d", Price);
}