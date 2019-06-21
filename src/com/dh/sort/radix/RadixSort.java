package com.dh.sort.radix;

import com.dh.sort.Sort;

/**
 * 基数排序，按照位数从小到大依次排序，效率极高
 * 
 * @author Lenovo
 *
 */
public class RadixSort implements Sort {

	@Override
	public void sort(int[] a, int n) {

		int max = a[0];

		/**
		 * 找出最大值
		 */
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		int temp = 1;

		for (; max / temp > 0; temp = temp * 10) {

			countSort(a, n, temp);
		}
	}

	/**
	 * 这里根据1-9 实现了一个计数排序。因此效率很高
	 * 
	 * @param a
	 * @param n
	 * @param cursor
	 */
	public void countSort(int[] a, int n, int cursor) {
		int[] c = new int[10];
		for (int i = 0; i < a.length; i++) {
			c[a[i] / cursor % 10]++;

		}

		for (int i = 1; i < 10; i++) {
			c[i] = c[i] + c[i - 1];
		}
		int[] temp = new int[n];
		for (int i = n-1; i >=0; i--) {
			int index = c[a[i] / cursor % 10]-1;
			
			c[a[i] / cursor % 10]--;
			temp[index] = a[i];
		}
		for (int i = 0; i < n; i++) {
			a[i] = temp[i];
		}

	}

}
