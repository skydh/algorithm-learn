package com.dh.search.binary;

/**
 * 二分查找，时间复杂度n(logn),缺点很多，数组（因为要支持随机访问）一大片连续的空间，有序。
 * 
 * @author Lenovo
 *
 */
public class RecursionBinarySearch {

	/**
	 * 第一次实现
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @param value
	 * @return
	 */
	public int search(int[] a, int low, int high, int value) {

		if (low > high)
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

	/**
	 * 有序数组的二分查找 第二次实现
	 * 
	 * @param a
	 * @param value
	 * @return
	 */
	public int searchNumber(int[] a, int value, int start, int end) {
		int middle = (start + end) / 2;
		if (a[middle] < value) {
			if (middle + 1 > end) {
				return -1;
			}
			return searchNumber(a, value, middle + 1, end);
		} else if (a[middle] == value) {
			return middle;
		} else {
			if (middle - 1 < start) {
				return -1;
			}
			return searchNumber(a, value, start, middle - 1);
		}
	}

	/**
	 * 
	 * 查询大于等于给定值的第一个元素的index
	 * 
	 * @param a
	 * @param value
	 * @return
	 */
	public int searchMoreThan(int[] a, int value, int start, int end) {
		int middle = (start + end) / 2;
		if (a[middle] < value) {
			if (middle + 1 > end) {
				while (a[middle] <= value) {
					if (middle >= a.length-1) {
						return -1;
					}
					middle++;
				}
				return ++middle;
			}
			return searchMoreThan(a, value, middle + 1, end);
		} else if (a[middle] == value) {
			while (a[middle] >= value) {
				if (middle <= 0) {
					return 0;
				}
				middle--;
			}
			return ++middle;

		} else {
			if (middle - 1 < start) {
				while (a[middle] >= value) {
					middle--;
				}
				return ++middle;
			}
			return searchMoreThan(a, value, start, middle - 1);
		}

	}

}
