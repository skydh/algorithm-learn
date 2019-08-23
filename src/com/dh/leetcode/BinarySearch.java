package com.dh.leetcode;

/**
 * 二分查找
 * 
 * 二分，查找，然后临界值是start==end;
 * 
 * @author Lenovo
 *
 */
public class BinarySearch {
	public int search(int[] nums, int target) {

		return search(nums,0,nums.length-1,target);

	}

	public int search(int[] nums, int start, int end, int target) {
		if (start == end) {
			if (nums[start] == target)
				return start;
			else
				return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] < target)
			return search(nums, mid + 1, end, target);
		else if (nums[mid] > target)
			return search(nums, start, mid , target);
		else
			return mid;

	}
	
	public static void main(String[] arg) {

		BinarySearch maximumProduct = new BinarySearch();
		int[] data = { -1,0,3,5,9,12 };

		System.out.println(maximumProduct.search(data,9));
	}
}
