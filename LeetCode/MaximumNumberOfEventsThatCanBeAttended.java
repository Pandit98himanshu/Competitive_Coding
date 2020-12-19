/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 */

					///////////////////////////
					// Segment Tree Solution // — WRONG ANSWER
					///////////////////////////

import java.util.*;
import java.io.*;

class MaximumNumberOfEventsThatCanBeAttended
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] events = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] s = in.readLine().split(" ");
			events[i][0] = Integer.parseInt(s[0]);
			events[i][1] = Integer.parseInt(s[1]);
		}
		System.out.println(new Solution().maxEvents(events));
	}
}
class Solution
{
	private int[] segTree;
	private int maxDate, size;

	public Solution()
	{ }
	public Solution(int[][] events)
	{
		int n = events.length;
		// sort events a/c to end date
        Arrays.sort(events, (a, b) -> a[1]-b[1]);
        // finding last date
        maxDate = events[n-1][1];
        // finding size of the tree
        size = 2*(int)Math.pow(2, Math.ceil(Math.log(maxDate)/Math.log(2)))+1;
        // initializing segement tree
        segTree = new int[size];
	}
    public int maxEvents(int[][] events)
    {
    	new Solution(events);
    	// build segment tree
    	buildTree(0, 1, maxDate);

    	int count = 0;							// stores answer
        for (int[] i : events)
        {
        	int day = getDay(0, 1, maxDate, i[0], i[1]);
        	if (day != Integer.MAX_VALUE)
        	{
        		count++;
        		updateTree(0, 1, maxDate, day);
        	}
        }
        return count;
    }
    // Segment Tree
    private void buildTree(int index, int start, int end)
    {
    	if (start > end)
    		return;
    	// Leaf Node
    	if (start == end)
    		segTree[index] = start;
    	else
    	{
    		int mid = (start+end)/2;
    		buildTree(2*index+1, start, mid);
    		buildTree(2*index+2, mid+1, end);
    		segTree[index] = Math.min(segTree[2*index+1], segTree[2*index+2]);
    	}
    }
    private void updateTree(int index, int start, int end, int day)
    {
    	// No Overlap
    	if (end < day || start > day)
    		return;
    	// Leaf Node
    	if (start == end)
    		segTree[index] = Integer.MAX_VALUE;
    	else
    	{
    		int mid = (start+end)/2;
    		updateTree(2*index+1, start, mid, day);
    		updateTree(2*index+2, start, mid, day);

    		segTree[index] = Math.min(segTree[2*index+1], segTree[2*index+2]);
    	}
    }
    private int getDay(int index, int start, int end, int l, int r)
    {
    	// No Overlap
		if (start > r || end < l)
			return Integer.MAX_VALUE;			// return Infinity
		// Complete Overlap (node_range completely lie b/w query_range)
		if (start >= l && end <= r)
			return segTree[index];				// return value of current node
		// Partial Overlap
		int mid = (start+end)/2;
		return Math.min(getDay(2*index+1, start, mid, l, r),
		                getDay(2*index+2, mid+1, end, l, r));
    }
}