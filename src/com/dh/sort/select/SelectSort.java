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

}
