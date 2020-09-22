#include <stdio.h>

void swap(int arr[], int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}

int main() {
	int arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
	int n = sizeof(arr)/sizeof(arr[0]);
	
	for(int i = 0; i < n; i++)
	    scanf("%d", &arr[i]);
	
	int i = 0, j = i+1;
	while(j < n) {
	    if(arr[i] != 0 && arr[j] != 0 || arr[i] != 0 && arr[j] == 0) {
	        i++;
	        j++;
	    }
	    if(arr[i] == 0 && arr[j] != 0) {
	        swap(arr, i, j);
	        i++;
	        j++;
	    }
	    if(arr[i] == 0 && arr[j] == 0) {
	        j++;
	    }
	}
	
	for (int k = 0; k < n; k++) {
	    printf("%d, ", arr[k]);
	}
	return 0;
}
