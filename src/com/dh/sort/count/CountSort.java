package com.dh.sort.count;

import com.dh.sort.Sort;

/**
 * 计数排序，你懂的，什么情况，就是数据,分析数据，这边计数范围是min-max
 * 
 * @author Lenovo
 *
 */
public class CountSort implements Sort {

	@Override
	public void sort(int[] a, int n) {

		int min = a[0];
		int max = a[0];

		/**
		 * 找出最大值，最小值
		 */
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			} else if (a[i] < min) {
				min = a[i];
			}
		}
		/**
		 * 创建一个计数数组,一个个遍历
		 */
		int length = max - min + 1;
		int[] c = new int[length];
		for (int i = 0; i < a.length; i++) {
			c[a[i] - min]++;
		}

		/**
		 * 让数组一个等于前面计算之和
		 */
		for (int i = 1; i < length; i++) {
			c[i] = c[i - 1] + c[i];
		}

		/**
		 * 根据c数组，我们通过a数组的值获取到c的值，这个值就是排序后的新值，然后减一。
		 */
		int[] temp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int index = c[a[i] - min] - 1;
			c[a[i] - min]--;
			temp[index] = a[i];

		}
		for (int i = 0; i < n; i++) {
			a[i] = temp[i];
		}

	}

}
