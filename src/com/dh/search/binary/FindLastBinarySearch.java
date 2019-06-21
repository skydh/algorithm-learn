package com.dh.search.binary;

/**
 * 查找最后一个元素等于给定值的位置
 * 
 * @author Lenovo
 *
 */
public class FindLastBinarySearch {
	public int search(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == value) {
				if (mid == 0)
					return mid;
				else if (a[mid + 1] == value) {
					low = mid + 1;
				} else {
					return mid;
				}
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1;

	}

}
