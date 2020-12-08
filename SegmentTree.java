import java.util.*;

class SegmentTree
{
	/**
	 * arr = elements given
	 * tree = segnent tree of arr
	 * index = index of current node
	 * start and end = range of node
	 */
	static void BuildTree(int[] arr, int[] tree, int index, int start, int end)
	{
		// Base Cases
		if (start > end)
			return;
		if (start == end)
		{
			tree[index] = arr[start];
			return;
		}

		// Recursive Cases
		int mid = (start+end)/2;

		// Build Left-SubTree
		BuildTree(arr, tree, 2*index+1, start, mid);
		// Build Right-SubTree
		BuildTree(arr, tree, 2*index+2, mid+1, end);
		
		int leftChild = tree[2*index+1];
		int rightChild = tree[2*index+2]; 
		tree[index] = Math.min(leftChild, rightChild);
	}
	/**
	 * index = index of current node
	 * start and end = range of node
	 * left and right = query range
	 */
	static int Query(int[] tree, int index, int start, int end, int l, int r)
	{
		// No Overlap
		if (start > r || end < l)
			return Integer.MAX_VALUE;			// return Infinity
		// Complete Overlap (node_range completely lie b/w query_range)
		if (start >= l && end <= r)
			return tree[index];					// return value of current node
		// Partial Overlap
		int mid = (start+end)/2;
		return Math.min(Query(tree, 2*index+1, start, mid, l, r),
		                Query(tree, 2*index+2, mid+1, end, l, r));
	}
	/**
	 * Only adds or subtacts value
	 */
	static void UpdateTree(int[] tree, int index, int start, int end, int l, int r, int value)
	{
		// No Overlap
		if (start > r || end < l)
			return;
		// Complete Overlap & leaf node (node_range completely lie b/w update_range)
		if ((start >= l && end <= r) && start == end)
		{
			tree[index] += value;
			return;
		}
		// Partial Overlap
		int mid = (start+end)/2;
		UpdateTree(tree, 2*index+1, start, mid, l, r, value);
		UpdateTree(tree, 2*index+2, mid+1, end, l, r, value);

		int leftChild = tree[2*index+1];
		int rightChild = tree[2*index+2];
		tree[index] = Math.min(leftChild, rightChild);
	}
	public static void main(String[] args)
	{
		int[] arr = { 1, 3, 4, 0, -2, 9 };
		int n = arr.length;

		int size = 2 * (int)Math.pow(2, Math.ceil(Math.log(n)/Math.log(2))) - 1;
		int[] segTree = new int[size];
		Arrays.fill(segTree, Integer.MAX_VALUE);

		BuildTree(arr, segTree, 0, 0, n-1);
		
		UpdateTree(segTree, 0, 0, n-1, 2, 4, 10);
		print(segTree);
	}

	static void print(Object...arr)
	{
		System.out.print(Arrays.deepToString(arr));
	}
}