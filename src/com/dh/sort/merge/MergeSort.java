package com.dh.sort.merge;

import com.dh.sort.Sort;

/**
 * 归并排序采用的是分而治之的算法思想，将一个大问题不断分解为一个个的子问题
 * ，我们将数组从中间划分为2部分，然后对前后2部分排序，再将排序好的部分在排序即可， T(n) = 2*T(n/2) + n；时间复杂度为这个T(n)
 * 就等于 O(nlogn)，平均，最好，最坏时间复杂度都是这个，但是不是原地排序，其空间复杂度是算法和时间复杂度算法一直，最后也是O(nlogn)，
 * 但是合并操作是函数的，每次操作都会申请，用完就释放了，因此最后的空间复杂度就是o(n),最多申请了n的空间来存放数组
 * 
 * 
 * @author Lenovo
 *
 */
public class MergeSort implements Sort {

	@Override
	public void sort(int[] a, int n) {

		sort(a, 0, n);
	}

	public void sort(int[] a, int start, int end) {

		/*
		 * 限定条件，拆分为不可拆分就停止，换句话来说也就是拆分到一个元素为止，然后向树一样不断向上排序。
		 */
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		sort(a, start, middle);
		sort(a, middle + 1, end);

		// 对排序好的2个子数组排序
		doSort(a, start, end, middle);

	}

	/**
	 * 有序数组的排序
	 * 方法如下：申请一个等于2个数组大小和的数组空间。定义2个游标分别指向各个数组头结点，比较2个数组的头元素，谁小就把值加进去，然后游标向后移动，
	 * 终止条件为任意一个数组放完了，然后再加一个判断，把其余数组元素全部加进去即可
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @param middle
	 */
	public void doSort(int[] a, int start, int end, int middle) {

		int[] temp = new int[end - start + 1];
		int i = start;
		int j = middle + 1;
		int cursor = 0;
		while (i <= middle && j <= end) {
			if (a[i] <= a[j]) {
				temp[cursor] = a[i];
				i++;
			} else {
				temp[cursor] = a[j];
				j++;
			}
			cursor++;
		}

		while (i <= middle) {// 将左边剩余元素填充进temp中
			temp[cursor++] = a[i++];
		}
		while (j <= end) {// 将右序列剩余元素填充进temp中
			temp[cursor++] = a[j++];
		}
		for (int k = 0; k < temp.length; k++) {
			a[start] = temp[k];
			start++;

		}

	}

	/**
	 * 第二次实现 归并排序采用的是分而治之的算法思想，将一个大问题不断分解为一个个的子问题
	 * 个人觉得，没那么复杂，直接中分，分成一个一个的节点，然后开始向上排序，知道最上层排序
	 * 
	 * @param a
	 */
	public void mergeSort(int[] a, int i, int j) {
		if (i == j) {
			return;
		}
		int mid = (i + j) / 2;
		mergeSort(a, i, mid);
		mergeSort(a, mid + 1, j);
		merge(a, i, j, mid);
	}

	/**
	 * 2个有序数组的合并
	 * 
	 * @param a
	 * @param i
	 * @param j
	 * @param mid
	 */
	public void merge(int[] a, int i, int j, int mid) {
		int[] temp = new int[j - i + 1];
		for (int k = i; k <= j; k++) {
			temp[k] = a[k];
		}

	}
}
