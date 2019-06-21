package com.dh.search.binary;

/**
 * 查找第一个大于等于给定值的元素
 * 
 * @author Lenovo
 *
 */
public class FindGreaterThanBinarySearch {
	public int search(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] < value) {
				low = mid + 1;
			} else if (mid == 0 && a[mid] >= value) {
				return mid;
			} else if (a[mid - 1] > value) {
				high = mid - 1;

			} else if (a[mid - 1] < value && a[mid] >= value) {
				return mid;
			}
		}
		return -1;
	}
}
