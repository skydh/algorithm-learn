package com.dh.search.binary;

/**
 * 二分查找，时间复杂度n(logn),缺点很多，数组（因为要支持随机访问）一大片连续的空间，有序。
 * @author Lenovo
 *
 */
public class RecursionBinarySearch {
	public int search(int[] a, int low, int high, int value) {

		if (low >high)
			return -1;

		int mid = low + (high - low) / 2;
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] > value) {
			return search(a, low, mid - 1, value);
		} else {
			return search(a, mid + 1, high, value);
		}

	}

}
