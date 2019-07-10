package com.dh.sort.select;

import com.dh.sort.Sort;

/**
 * 选择排序，原地排序，不稳定排序（存在相同元素排序后位置发生变化），时间复杂度最大最小，平均都是o(n2)
 * 不断在未排序的区间选出最小的元素，放到已排序的末尾。
 * 
 * @author Lenovo
 *
 */
public class SelectSort implements Sort {

	@Override
	public void sort(int[] a, int n) {
		// 设定未排序空间是全部元素
		for (int i = 0; i < n; i++) {
			int mix = i;

			// 找到最小元素的坐标
			for (int j = i + 1; j < n; j++) {
				if (a[mix] > a[j]) {
					mix = j;
				}
			}
			// 判读这个坐标是不是原先的，是则不变，不是则交换元素，未排序最小元素就放到排序后的末尾了。
			if (i != mix) {
				int temp = a[i];
				a[i] = a[mix];
				a[mix] = temp;

			}

		}

	}

	/**
	 * 第二次选择排序，个人觉得蛮简单的，分为2个分区，已排序和未排序，每次在未排序的地方选最小的元素添加到已排序的空间后面。
	 * 说实话，这个算法写着写着和冒泡没区别了，哈哈哈哈，但是，老夫又重温了一下之前的代码，还是觉得没啥区别无非就是少了几次交换bale
	 * 
	 * @param a
	 */
	public void sort(int[] a) {

		for (int i = 0; i < a.length; i++) {

			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}

			}
		}

	}

	/**
	 * 交换数据
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
