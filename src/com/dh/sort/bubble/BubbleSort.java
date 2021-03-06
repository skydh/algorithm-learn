package com.dh.sort.bubble;

import com.dh.sort.Sort;

/**
 * 冒泡排序，该算法最优时间复杂度为O(n),最坏时间复杂度为o(n2),平均时间复杂度为o(n2),原地排序（不需要额外的空间），稳定排序
 * （以前顺序一样的元素不会随着排序而变化）
 * 从第一个元素开始遍历，谁大就交换，不断交换，到数组末尾，元素已经是最大的了，然后依次类推，直到未排序数组只剩下一个元素停止
 * 
 * @author Lenovo
 *
 */
public class BubbleSort implements Sort {

	/**
	 * 冒泡排序从小到大排序 这是第一次写冒泡排序
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	public void sort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = false;
				}
			}
			if (flag)
				return;
		}
		return;
	}

	/**
	 * 这是第二次写冒泡排序 冒泡就是大的数据一点一点冒泡，冒出去
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
